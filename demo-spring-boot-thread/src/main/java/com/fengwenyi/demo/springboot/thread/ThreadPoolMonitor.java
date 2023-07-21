package com.fengwenyi.demo.springboot.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-10
 */
public class ThreadPoolMonitor {

    private static final ConcurrentMap<String, ThreadPoolBo> map = new ConcurrentHashMap<>();

    public static void set(String threadPoolName, ThreadPoolBo threadPoolBo) {
        map.put(threadPoolName, threadPoolBo);
    }

    public static List<ThreadPoolDetailInfo> getDetailList() {
        List<ThreadPoolDetailInfo> list = new ArrayList<>(map.size());
        for (Map.Entry<String, ThreadPoolBo> entry : map.entrySet()) {
            String key = entry.getKey();
            ThreadPoolBo threadPoolBo = entry.getValue();
            if (!StringUtils.hasText(key) || Objects.isNull(threadPoolBo)) {
                continue;
            }
            ThreadPoolTaskExecutor executor = threadPoolBo.getThreadPoolTaskExecutor();
            ThreadPoolExecutor threadPoolExecutor = executor.getThreadPoolExecutor();

            if (threadPoolExecutor.isShutdown()) {
                // 线程池被关闭，不统计
                continue;
            }

            BigDecimal activePercent = new BigDecimal(executor.getActiveCount())
                    .divide(new BigDecimal(executor.getMaxPoolSize()), 2, 4);

            BigDecimal load = new BigDecimal(executor.getPoolSize())
                    .divide(new BigDecimal(executor.getMaxPoolSize()), 2, 4);

            list.add(
                    new ThreadPoolDetailInfo()
                            .setThreadPoolName(key)
                            .setPoolSize(executor.getPoolSize())
                            .setCorePoolSize(executor.getCorePoolSize())
                            .setLargestPoolSize(threadPoolExecutor.getLargestPoolSize())
                            .setMaximumPoolSize(executor.getMaxPoolSize())
                            .setCompletedTaskCount(threadPoolExecutor.getCompletedTaskCount())
                            .setActive(threadPoolExecutor.getActiveCount())
                            .setTask(threadPoolExecutor.getTaskCount())
                            .setKeepAliveTime(threadPoolExecutor.getKeepAliveTime(TimeUnit.MILLISECONDS))
                            .setQueueSize(threadPoolExecutor.getQueue().size())
                            .setQueueCapacity(threadPoolBo.getQueueCapacity())
                            .setQueueRemainingCapacity(threadPoolExecutor.getQueue().remainingCapacity())
                            .setLoad(new Double(load.doubleValue() * 100).intValue())
                            .setHost(threadPoolBo.getIp())
                            .setActivePercent(new Double(activePercent.doubleValue() * 100).intValue())
            );
        }
        return list;
    }
}
