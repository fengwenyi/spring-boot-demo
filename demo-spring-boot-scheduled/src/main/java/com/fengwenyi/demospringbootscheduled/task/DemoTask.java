package com.fengwenyi.demospringbootscheduled.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-21
 */
@Component
@Slf4j
public class DemoTask {

    @Scheduled(initialDelay = 5, fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void dataSynchronizationTask() {
        log.info("开始执行数据同步任务");
    }

}
