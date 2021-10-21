package com.fengwenyi.demospringbootscheduled.task;

import com.fengwenyi.demospringbootscheduled.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-09-29
 */
@Component
@Slf4j
public class ScheduledTask {

    private static final ExecutorService exec = Executors.newFixedThreadPool(10);


    public static class SubThread extends Thread {
        private final String id;
        private final int sleepTime;

        public SubThread(String id, int sleepTime) {
            this.sleepTime = sleepTime;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(sleepTime * 1000L);
                log.info("{}, 线程={}，睡眠时间 {} s", id, Thread.currentThread().getName(), sleepTime);
            } catch (Exception e) {

            }
        }
    }


    // fixedDelay 间隔时间大于任务时间
    // @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelay01() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            int random = 3;
            int sleepTime = random * 1000;
            Thread.sleep(sleepTime);
            log.info("{}, 线程={}，睡眠时间={}", id, Thread.currentThread().getName(), random);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

    // fixedDelay 间隔时间小于任务时间
    //@Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelay02() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            int random = 5;
            int sleepTime = random * 1000;
            Thread.sleep(sleepTime);
            log.info("{}, 线程={}，睡眠时间={}", id, Thread.currentThread().getName(), random);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

    // fixedDelay 多线程 间隔时间大于任务时间
    // @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelayAsync01() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            exec.execute(new SubThread(id, 3));
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

    // fixedDelay 多线程 间隔时间小于任务时间
    // @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void testFixedDelayAsync02() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            exec.execute(new SubThread(id, 6));
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

    // fixedRate 间隔时间大于任务时间
//     @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    public void testFixedRate01() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            int random = 3;
            int sleepTime = random * 1000;
            Thread.sleep(sleepTime);
            log.info("{}, 线程={}，睡眠时间={}", id, Thread.currentThread().getName(), random);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

    // fixedRate 间隔时间小于任务时间
    // @Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS)
    public void testFixedRate02() {
        String id = Utils.genId();
        log.info("{}--------------定时任务开始", id);
        try {
            int random = 5;
            int sleepTime = random * 1000;
            Thread.sleep(sleepTime);
            log.info("{}, 线程={}，睡眠时间={}", id, Thread.currentThread().getName(), random);
        } catch (Exception e) {

        }
        log.info("{}==============定时任务结束==============", id);
    }

}
