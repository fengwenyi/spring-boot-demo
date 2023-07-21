package com.fengwenyi.demo.springboot.thread;

import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-11
 */
@Component
@Slf4j
public class ThreadPoolMonitorTask {

    private static final String THREAD_POOL = "demoThreadPool";

    public void threadPoolDetail(Integer loadWarnValue) {
        List<ThreadPoolDetailInfo> list = ThreadPoolMonitor.getDetailList();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        int LOAD_WARN_NUM = 80;
        if (Objects.nonNull(loadWarnValue) && loadWarnValue > -1) {
            LOAD_WARN_NUM = loadWarnValue;
        }
        for (ThreadPoolDetailInfo info : list) {
            if (info.getLoad() >= LOAD_WARN_NUM) {
                log.info("[{}], [{}], thread pool load more than {} percent, {}",
                        THREAD_POOL, info.getThreadPoolName(), LOAD_WARN_NUM,
                        JsonUtils.convertString(info.convertLogMap()));
            }
        }
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void threadPoolMonitorTask() {
        try {
            Integer loadWarnValue = null;
            threadPoolDetail(loadWarnValue);
        } catch (Exception e) {
            log.error("[{}], threadPoolMonitorTask exception: {}", THREAD_POOL, e.getLocalizedMessage(), e);
        }
    }

}
