package com.fengwenyi.demospringbootscheduled.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

//    @Scheduled(initialDelay = 5, fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void dataSynchronizationTask() {
        log.info("开始执行数据同步任务");
    }

//    @Scheduled(cron = "${erwin.cron:0/2 * * * * ?}")
    public void cronTaskYmlDemo() {
        log.info("cron yml demo");
    }

//    @Scheduled(initialDelay = 5, fixedDelayString = "${erwin.fixed-delay:2}", timeUnit = TimeUnit.SECONDS)
    public void fixedDelayTaskYmlDemo() {
        log.info("fixedDelay yml demo");
    }

    @Scheduled(initialDelay = 5, fixedRateString = "${erwin.fixed-rate:2}", timeUnit = TimeUnit.SECONDS)
    public void fixedRateTaskYmlDemo() {
        log.info("fixedRate yml demo");
    }
}
