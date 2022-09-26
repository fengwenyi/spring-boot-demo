package com.fengwenyi.springboot.redisson;

import com.fengwenyi.javalib.generate.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        try {
            log.info("{}, lock request", traceId);
            rLock.lock(5, TimeUnit.SECONDS);
            log.info("{}, lock success", traceId);
        } catch (Exception e) {
            log.error("{}, lock exception", traceId);
            return "get lock failed";
        }

        log.info("{}, business start", traceId);

        try {
            TimeUnit.SECONDS.sleep(10);
            log.info("{}, business success", traceId);
            return "success";
        } catch (Exception e) {
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
