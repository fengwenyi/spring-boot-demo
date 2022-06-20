package com.fengwenyi.springboot.redisson;

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

        RLock lock = redissonClient.getLock("lock");
        if (Objects.isNull(lock)) {
            return "failed";
        }
        try {
            lock.lock(60, TimeUnit.SECONDS);

            // do something
            Thread.sleep(5 * 1000);

            log.info("处理业务结束");

        } catch (Exception e) {
            log.error("test lock error: [{}]", e.getLocalizedMessage(), e);
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }

        return "success";
    }

}
