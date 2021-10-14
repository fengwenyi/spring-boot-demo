package com.fengwenyi.demospringbootscheduled.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
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
    //@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelay() {
        log.info("test fixedDelay");
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedRate() {
        test();
    }

    @Async
    public void test() {
        String traceId = UUID.randomUUID().toString().replaceAll("-", "");
        log.info("test fixedRate {} start ", traceId);
        int sleepTime = ThreadLocalRandom.current().nextInt(10);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test fixedRate {} end {}", traceId, sleepTime);
    }

    private static final ExecutorService exec = Executors.newFixedThreadPool(10);


    public static class SubThread extends Thread {
        private final int i;

        public SubThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            super.run();
        }
    }
}
