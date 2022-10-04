package com.fengwenyi.springboot.redisson;

import com.fengwenyi.javalib.generate.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-20
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    private final RedissonClient redissonClient;

    public ApiController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @RequestMapping("/testLock")
    public String testLock() {
        String traceId = IdUtils.genId();
        log.info("{}, request enter", traceId);
        RLock lock = redissonClient.getLock("lock");
        if (Objects.isNull(lock)) {
            log.error("{}, lock null", traceId);
            return "failed";
        }
        log.info("{}, get lock", traceId);
        try {

            // lock.lock(60, TimeUnit.SECONDS);

            boolean tryLock = lock.tryLock(6, TimeUnit.SECONDS);

            log.info("{}, try lock", traceId);
            if (tryLock) {
                log.info("{}, try lock success", traceId);
                // do something
                Thread.sleep(10 * 1000);

                log.info("{}, 处理业务结束", traceId);

                return "success";
            } else {
                log.error("{}, try lock failed", traceId);
            }

        } catch (Exception e) {
            log.error("test lock error: [{}]", e.getLocalizedMessage(), e);
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }

        return "failed";
    }


    @RequestMapping("/testNotLock")
    public String testNotLock() {
        String traceId = IdUtils.genId();
        log.info("{}, request enter", traceId);
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info("{}, finished", traceId);
            return "success";
        } catch (InterruptedException e) {
            log.info("{}, exception, {}", traceId, e.getLocalizedMessage(), e);
            return "failed";
        }
    }

    @RequestMapping("/testLock2")
    public String testLock2(String id) {
//        String traceId = IdUtils.genId();
        String traceId = id;
        log.info("{}, request enter", traceId);
        RLock lock = redissonClient.getLock("lock");
        if (Objects.isNull(lock)) {
            log.error("{}, lock null", traceId);
            return "exception";
        }

        log.info("{}, get lock", traceId);

        boolean tryLock;
        try {
//            tryLock = lock.tryLock(30, TimeUnit.SECONDS);
            tryLock = lock.tryLock(3, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("{}, lock exception", traceId);
            return "lock exception";
        }

//        tryLock = lock.tryLock();

        if (!tryLock) {
            log.error("{}, try lock failed", traceId);
            return "exception";
        }

        log.info("{}, get lock success", traceId);

        try {
            TimeUnit.SECONDS.sleep(20);
            log.info("{}, business success", traceId);
            return "success";
        } catch (Exception e) {
            log.error("{}, business error", traceId);
            return "failed";
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
//            lock.unlock();
            /*
            java.lang.IllegalMonitorStateException: attempt to unlock lock, not locked by current thread by node id: 526bb8c9-c033-4aa5-b977-a9e7163da9bf thread-id: 61
             */
        }
    }

    @RequestMapping("/testLock3")
    public String testLock3(String id) {
//        String traceId = IdUtils.genId();
        String traceId = id;
        log.info("{}, request enter", traceId);
        RLock lock = redissonClient.getLock("lock");
        if (Objects.isNull(lock)) {
            log.error("{}, lock null", traceId);
            return "exception";
        }

        log.info("{}, get lock", traceId);

//        lock.lock();
        lock.lock(5, TimeUnit.SECONDS);
        // lock.lock

        log.info("{}, get lock success", traceId);

        try {
            TimeUnit.SECONDS.sleep(20);
            log.info("{}, business success", traceId);
            return "success";
        } catch (Exception e) {
            log.error("{}, business error", traceId);
            return "failed";
        } finally {
//            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            }
//            lock.unlock(); // error
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    @RequestMapping("/testLock4")
    public String testLock4() {
        String traceId = IdUtils.genId();
        log.info("{}, request enter", traceId);
        RLock lock = redissonClient.getLock("lock");
        if (Objects.isNull(lock)) {
            log.error("{}, lock null", traceId);
            return "exception";
        }

        log.info("{}, get lock", traceId);

        try {
            lock.lock(5, TimeUnit.SECONDS);

            log.info("{}, lock success", traceId);

            try {
                TimeUnit.SECONDS.sleep(10);
                log.info("{}, business success", traceId);
                return "success";
            } catch (Exception e) {
                log.error("{}, business error, {}", traceId, e.getLocalizedMessage(), e);
                return "failed";
            } finally {
                if (lock.isLocked()) {
                    lock.unlock();
                }
            }

        } catch (Exception e) {
            log.error("{}, lock failed, {}", traceId, e.getLocalizedMessage(), e);
        }

        return "exception";
    }
}
