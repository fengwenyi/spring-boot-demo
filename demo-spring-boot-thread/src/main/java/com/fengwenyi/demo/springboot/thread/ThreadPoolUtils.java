package com.fengwenyi.demo.springboot.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;

import java.util.concurrent.RejectedExecutionHandler;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-11
 */
public class ThreadPoolUtils {


    public static ThreadPoolTaskExecutor genExecutor(int threadPoolSize,
                                                 int maxPoolSize,
                                                 int queueCapacity,
                                                 int keepAliveSeconds,
                                                 String threadNamePrefix,
                                                 RejectedExecutionHandler rejectedExecutionHandler) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(rejectedExecutionHandler);
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();

        String ip = (String) MemoryStorageUtils.get(Constants.KEY_LOCAL_IP);
        if (!StringUtils.hasText(ip)) {
            ip = IpUtils.getLocalIp();
            MemoryStorageUtils.set(Constants.KEY_LOCAL_IP, ip);
        }

        ThreadPoolBo threadPoolBo = new ThreadPoolBo()
                .setIp(ip)
                .setThreadPoolTaskExecutor(executor)
                .setQueueCapacity(queueCapacity)
                ;
        ThreadPoolMonitor.set(threadNamePrefix.substring(0, threadNamePrefix.lastIndexOf("-")), threadPoolBo);

        return executor;
    }

}
