package com.fengwenyi.demospringbootscheduled.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-29
 */
@Component
@Slf4j
public class ScheduledTask {

    // @Scheduled(cron = "")
    public void testCron() {

    }


    // 间隔5秒执行一次
    //@Scheduled(fixedDelay = 5000)
    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelay() {
        log.info("test fixedDelay");
    }
}
