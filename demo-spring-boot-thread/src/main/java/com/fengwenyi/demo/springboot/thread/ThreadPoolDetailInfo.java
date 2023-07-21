package com.fengwenyi.demo.springboot.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ThreadPoolDetailInfo {

    private static final String THREAD_POOL_LOAD_WARN = "threadPoolLoadWarn";

    //线程池名字
    private String threadPoolName;
    //当前线程池大小
    private Integer poolSize;
    //线程池核心线程数量
    private Integer corePoolSize;
    //线程池生命周期中最大线程数量
    private Integer largestPoolSize;
    //线程池中允许的最大线程数
    private Integer maximumPoolSize;
    //线程池完成的任务数目
    private long completedTaskCount;
    //线程池中当前活跃个数
    private Integer active;
    //线程池完成的任务个数
    private long task;
    //线程最大空闲时间
    private long keepAliveTime;
    //当前活跃线程的占比
    private int activePercent;
    //任务队列容量（阻塞队列）
    private Integer queueCapacity;
    //任务队列剩余容量（阻塞队列）
    private Integer queueRemainingCapacity;
    //当前队列中任务的数量
    private Integer queueSize;
    //线程池中任务平均执行时长
//    private long avgExecuteTime;
    // host
    private String host;
    // host
    private Integer load;

    public Map<String, Object> convertLogMap() {
        return MapHelper.init()
                .put("key", THREAD_POOL_LOAD_WARN)
                .put("poolSize", poolSize)
                .put("corePoolSize", corePoolSize)
                .put("largestPoolSize", largestPoolSize)
                .put("maximumPoolSize", maximumPoolSize)
                .put("active", active)
                .put("activePercent", convertPercent(activePercent))
                .put("task", task)
                .put("completedTaskCount", completedTaskCount)
                .put("queueSize", queueSize)
                .put("queueCapacity", queueCapacity)
                .put("queueRemainingCapacity", queueRemainingCapacity)
                .put("host", host)
                .put("load", convertPercent(load))
                .build();
    }

    private String convertPercent(Integer num) {
        return (Objects.nonNull(num) && num > 0) ? num + "%" : String.valueOf(num);
    }

}
