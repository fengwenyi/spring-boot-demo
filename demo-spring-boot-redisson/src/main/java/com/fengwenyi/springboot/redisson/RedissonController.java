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
 * @since 2022-09-26
 */
@Slf4j
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    private final RedissonClient redissonClient;

    public RedissonController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @RequestMapping("/lock")
    public String lock() {
        String traceId = IdUtils.genId();
        log.info("{}, request enter", traceId);
        RLock rLock = redissonClient.getLock("demo-spring-boot-redisson:lock");

        log.info("{}, get lock", traceId);

//        rLock.lock(5, TimeUnit.SECONDS); // 锁5秒释放，下一个业务就会进来
//        rLock.lock(); // 如果你不明确你的业务耗时，要求严格，就这样
        rLock.lock(1, TimeUnit.MINUTES); // 如果你明确你的业务，或者，将锁释放时间拉长

        log.info("{}, get lock success", traceId);

        try {
            TimeUnit.SECONDS.sleep(10);
            log.info("{}, business success", traceId);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        } finally {
            if (rLock.isLocked()) {
                if (rLock.isHeldByCurrentThread()) {
                    rLock.unlock();
                }
            }
        }
    }

@RequestMapping("/tryLock")
public String tryLock() {
    String traceId = IdUtils.genId();
    log.info("{}, request enter", traceId);
    RLock rLock = redissonClient.getLock("demo-spring-boot-redisson:tryLock");
    if (Objects.isNull(rLock)) {
        log.error("{}, lock null", traceId);
        return "exception";
    }

    log.info("{}, get lock", traceId);

    boolean tryLock;
    try {
//            tryLock = rLock.tryLock(30, TimeUnit.SECONDS);
        tryLock = rLock.tryLock(3, 30, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
        log.error("{}, lock exception", traceId);
        return "lock exception";
    }

    if (!tryLock) {
        log.error("{}, try lock failed", traceId);
        return "exception";
    }

    try {
        TimeUnit.SECONDS.sleep(20);
        log.info("{}, business success", traceId);
        return "success";
    } catch (Exception e) {
        log.error("{}, business error", traceId);
        return "failed";
    } finally {
        if (rLock.isLocked()) {
            if (rLock.isHeldByCurrentThread()) {
                rLock.unlock();
            }
        }
    }
}

}
