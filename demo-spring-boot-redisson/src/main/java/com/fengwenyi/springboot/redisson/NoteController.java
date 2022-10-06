package com.fengwenyi.springboot.redisson;

import com.fengwenyi.javalib.generate.IdUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 写笔记使用
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-06
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    private final RedissonClient redissonClient;

    public NoteController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @RequestMapping("/simulate-lock")
    public String simulateLock() {
        RLock rLock = redissonClient.getLock("demo-spring-boot-redisson:simulate-lock");
        if (Objects.isNull(rLock)) {
            return "exception";
        }
        try {
            boolean tryLock = rLock.tryLock(5, TimeUnit.SECONDS);
            if (tryLock) {
                TimeUnit.SECONDS.sleep(20);
                return "success";
            } else {
                return "get lock failed";
            }
        } catch (Exception e) {
            return "lock exception";
        } finally {
            /*if (rLock.isLocked()) {
                rLock.unlock();
            }*/
            rLock.unlock();
        }
    }

    @RequestMapping("/try-lock")
    public String tryLock() {

        RLock rLock = redissonClient.getLock("demo-spring-boot-redisson:try-lock");
        if (Objects.isNull(rLock)) {
            return "lock exception";
        }

        boolean tryLock;
        try {
            tryLock = rLock.tryLock(3, 60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return "get lock exception";
        }
        if (!tryLock) {
            return "get lock failed";
        }

        try {
            TimeUnit.SECONDS.sleep(20);
            return "success";
        } catch (Exception e) {
            return "business exception";
        } finally {
            if (rLock.isLocked() && rLock.isHeldByCurrentThread()) {
                rLock.unlock();
            }
        }
    }

    @RequestMapping("/lock")
    public String lock() {
        RLock rLock = redissonClient.getLock("demo-spring-boot-redisson:lock");
        if (Objects.isNull(rLock)) {
            return "exception";
        }
        try {
            rLock.lock(5, TimeUnit.SECONDS);
            System.out.println("execute business");
            TimeUnit.SECONDS.sleep(20);
            return "success";
        } catch (Exception e) {
            return "lock exception";
        } finally {
            /*if (rLock.isLocked()) {
                rLock.unlock();
            }*/
            rLock.unlock();
        }
    }

}
