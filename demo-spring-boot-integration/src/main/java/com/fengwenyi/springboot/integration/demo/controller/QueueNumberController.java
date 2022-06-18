package com.fengwenyi.springboot.integration.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-19
 */
@RestController
@RequestMapping("/queueNumber")
@Slf4j
public class QueueNumberController {

    private int m = 0, n = 0;

    private RedisLockRegistry redisLockRegistry;

    public static ConcurrentHashMap<Integer, Integer> unLockMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, Integer> lockMap = new ConcurrentHashMap<>();

    @Autowired
    public void setRedisLockRegistry(RedisLockRegistry redisLockRegistry) {
        this.redisLockRegistry = redisLockRegistry;
    }

    @RequestMapping("/testUnLock")
    public int testUnLock() {

        m = m + 1;

        new UnLockThread(m).start();

        return m;
    }

    @RequestMapping("/testLock")
    public int testLock() {

        Lock lock = redisLockRegistry.obtain("queue-number");
        try {
            if (lock.tryLock(30, TimeUnit.SECONDS)) {

                n = n + 1;

                new LockThread(n).start();

                return n;

            } else {
                throw new RuntimeException("redis lock failed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(lock)) {
                lock.unlock();
            }
        }
    }

    public static class UnLockThread extends Thread {

        private final int num;

        public UnLockThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            Integer mVal = unLockMap.get(num);

            if (Objects.nonNull(mVal)) {
                log.error("testUnLock, [{}]，排队号码重复：[{}]", Thread.currentThread().getName(), num);
            } else {
                unLockMap.put(num, 1);
            }
        }
    }

    public static class LockThread extends Thread {

        private final int num;

        public LockThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            Integer mVal = lockMap.get(num);

            if (Objects.nonNull(mVal)) {
                log.error("testLock, [{}]，排队号码重复：[{}]", Thread.currentThread().getName(), num);
            } else {
                lockMap.put(num, 1);
            }
        }
    }

}
