package com.fengwenyi.demo.springboot.aop.aspect;

import com.fengwenyi.demo.springboot.aop.annotation.MySecondAop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-11
 */
@Slf4j
@Aspect
@Component
@Order(100003)
public class MySecondAspect {

    @Around("@annotation(aop)")
    public Object around(ProceedingJoinPoint joinPoint, MySecondAop aop) throws Throwable {

        log.info("MySecondAspect#around execute start");

        try {
            return joinPoint.proceed();
        } finally {
            log.info("MySecondAspect#around execute end");
        }

    }

}
