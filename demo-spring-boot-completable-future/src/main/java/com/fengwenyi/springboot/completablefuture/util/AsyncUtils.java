package com.fengwenyi.springboot.completablefuture.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-19
 */
public class AsyncUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncUtils.class);

    /**
     * {@link ThreadPoolTaskExecutor}
     * 与{@link Executors#newFixedThreadPool(int)}
     * 内部使用的都是{@link ThreadPoolExecutor}
     */
    private static final ThreadPoolTaskExecutor EXECUTOR;

    static {
        EXECUTOR = new ThreadPoolTaskExecutor() {

            private static final long serialVersionUID = -1644198965440814899L;

            @Override
            protected ExecutorService initializeExecutor(ThreadFactory threadFactory,
                                                         RejectedExecutionHandler rejectedExecutionHandler) {
                try {
                    return this.getThreadPoolExecutor();
                } catch (IllegalStateException ise) {
                    //因为下面已经手动调用了afterPropertiesSet()来初始化线程池，
                    //如果AsyncUtils处于IOC环境中，@Bean("AsyncUtils_TaskExecutor")的使用
                    //会使Spring再次调用afterPropertiesSet()，
                    //所以通过这种方式来避免new出两个java.util.concurrent.ThreadPoolExecutor
                }
                return super.initializeExecutor(threadFactory, rejectedExecutionHandler);
            }
        };

        EXECUTOR.setCorePoolSize(2);
        EXECUTOR.setMaxPoolSize(10);
        EXECUTOR.setAllowCoreThreadTimeOut(true);
        EXECUTOR.setWaitForTasksToCompleteOnShutdown(true);
        EXECUTOR.setThreadNamePrefix("AsyncUtils_");
        EXECUTOR.setTaskDecorator(AsyncUtils::wrapRunnable);
        EXECUTOR.setBeanName("AsyncUtils_TaskExecutor");
        //如果线程池超载了，拒绝策略为: 直接使用调用该execute的线程本身来执行
        EXECUTOR.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        EXECUTOR.afterPropertiesSet();//手动调用afterPropertiesSet()以保证非IOC环境下也可以初始化线程池

        //注意，非IOC环境下需要手动关闭线程池
    }

    /**
     * 获取线程池执行器. <br>
     * 如果想用当前工具类的线程池覆盖TaskExecutionAutoConfiguration的配置 <br>
     * 则可以在SpringBoot启动类或其他配置类上使用@Import({AsyncUtils.class}) <br>
     * 此时，application.properties中spring.task.execution开头的配置将无效 <br>
     * 如果想使用spring.task.execution开头的这些配置，请不要把当前工具类加载到IOC容器中 <br>
     * 或者自己了解TaskExecutionAutoConfiguration和当前工具类的运行过程再另行处理
     *
     * @return ThreadPoolTaskExecutor
     * @see org.springframework.context.annotation.Import
     * <div>@see org.springframework.boot.autoconfigure.task.TaskExecutionProperties</div>
     * <div>@see org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration</div>
     */
    @Bean("AsyncUtils_TaskExecutor")
    @Primary
    public static ThreadPoolTaskExecutor getExecutor() {
        return EXECUTOR;
    }

    /**
     * 关闭线程池. <br>
     * 停止接收外部submit的任务 <br>
     * 内部正在跑的任务和队列里等待的任务，会执行完 <br>
     * 等到第二步完成后，才真正停止
     */
    public static void shutdownExecutor() {
        EXECUTOR.setWaitForTasksToCompleteOnShutdown(true);
        EXECUTOR.shutdown();
    }

    /**
     * 马上关闭线程池. <br>
     * 跟shutdownExecutor()一样，先停止接收外部提交的任务 <br>
     * 忽略队列里等待的任务 <br>
     * 尝试将正在跑的任务interrupt中断 <br>
     * java.util.concurrent.ThreadPoolExecutor的shutdown()将返回未执行的任务列表(见其源码)
     */
    public static void shutdownExecutorNow() {
        EXECUTOR.setWaitForTasksToCompleteOnShutdown(false);
        EXECUTOR.shutdown();
    }

    /**
     * 异步执行任务.
     *
     * @param runnable Runnable的实现类
     */
    public static void asyncExecute(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        EXECUTOR.execute(runnable);
    }

    /**
     * 异步执行任务并获取Future对象.
     *
     * @param callable Callable的实现类
     * @param <T>      泛型类
     * @return Future
     */
    public static <T> Future<T> asyncSubmit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        return EXECUTOR.submit(wrapCallable(callable));
    }

    /**
     * 指定线程名开启一个新的异步线程并执行任务. <br>
     * 此方法不使用线程池
     *
     * @param threadName 线程名
     * @param runnable   Runnable的实现类
     */
    public static void asyncExecute(String threadName, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        new Thread(wrapRunnable(runnable), threadName).start();
    }

    /**
     * 包装一下runnable，使得run()异常时捕获异常信息并log一下.
     *
     * @param runnable Runnable实例
     * @return 包装过的Runnable实例
     */
    private static Runnable wrapRunnable(Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Throwable t) {
                LOGGER.error("异步线程执行异常 : ", t);
            }
        };
    }

    /**
     * 包装一下runnable，使得call()异常时捕获异常信息并log一下.
     *
     * @param callable Callable实例
     * @return 包装过的Callable实例
     */
    private static <T> Callable<T> wrapCallable(Callable<T> callable) {
        return () -> {
            try {
                return callable.call();
            } catch (Throwable t) {
                LOGGER.error("异步线程执行异常 : ", t);
                throw t;
            }
        };
    }

}
