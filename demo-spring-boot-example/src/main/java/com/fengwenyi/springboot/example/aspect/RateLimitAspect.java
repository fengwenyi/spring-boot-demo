package com.fengwenyi.springboot.example.aspect;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.example.annotation.RateLimit;
import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 接口限流
 *
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-30
 */
@Aspect
@Component
@Slf4j
public class RateLimitAspect extends BaseAspect {

    private static ConcurrentMap<String, RateLimiterBo> rateLimiterMap = new ConcurrentHashMap<>();

    @Data
    @Accessors(chain = true)
    static class RateLimiterBo {

        private String key;

        private RateLimiter rateLimiter;

        private Double permitsPerSecond;

    }

    @Around("@annotation(rateLimit)")
    public Object around(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {

        String apiKey = rateLimit.value();
        String message = rateLimit.message();
        if (!StringUtils.hasText(message)) {
            message = "System Busy";
        }

        if (!StringUtils.hasText(apiKey)) {
            return ResultTemplate.fail();
        }

        RateLimiterBo rateLimiterBo = new RateLimiterBo()
                .setKey(apiKey)
                .setPermitsPerSecond(rateLimit.permitsPerSecond())
                ;

        RateLimiter rateLimiter = getRateLimiter(rateLimiterBo);

        if (rateLimiter.tryAcquire(rateLimit.timeout(), rateLimit.timeunit())) {
            return joinPoint.proceed();
        } else {
            log.warn("[{}], business_busy", apiKey);
            return ResultTemplate.fail(message);
        }
    }

    private RateLimiter initRateLimiter(RateLimiterBo rateLimiterBo) {
        Double permitsPerSecond = rateLimiterBo.getPermitsPerSecond();
        RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);
        rateLimiterBo.setRateLimiter(rateLimiter);
        rateLimiterMap.put(rateLimiterBo.getKey(), rateLimiterBo);
        return rateLimiter;
    }

    private RateLimiter getRateLimiter(RateLimiterBo rateLimiterBo) {
        RateLimiterBo mapBo = rateLimiterMap.get(rateLimiterBo.getKey());
        if (Objects.isNull(mapBo)) {
            return initRateLimiter(rateLimiterBo);
        }
        if (Objects.equals(mapBo.getPermitsPerSecond(), rateLimiterBo.getPermitsPerSecond())) {
            return mapBo.getRateLimiter();
        }
        return initRateLimiter(rateLimiterBo);
    }
}
