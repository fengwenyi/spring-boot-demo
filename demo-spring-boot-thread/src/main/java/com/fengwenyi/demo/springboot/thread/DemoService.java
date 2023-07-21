package com.fengwenyi.demo.springboot.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-07-21
 */
@Service
@Slf4j
public class DemoService {

    public void thread() {
        List<Integer> task = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            task.add(i);
        }
        ThreadPoolTaskExecutor executor = ThreadPoolUtils.genExecutor(
                10,
                20,
                2048,
                60,
                "asyncTask-",
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        CountDownLatch executorCountDownLatch = new CountDownLatch(task.size());
        for (Integer t : task) {
            executor.submit(() -> {
                try {
                    log.info("task[{}], start", t);
                    TimeUnit.SECONDS.sleep(3);
                    log.info("task[{}], finished", t);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    executorCountDownLatch.countDown();
                }
            });
        }
        try {
            executorCountDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

}
