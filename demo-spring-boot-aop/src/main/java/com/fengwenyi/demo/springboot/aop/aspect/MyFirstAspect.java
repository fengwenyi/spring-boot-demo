package com.fengwenyi.demo.springboot.aop.aspect;

import com.fengwenyi.demo.springboot.aop.annotation.MyFirstAop;
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
@Order(100002)
public class MyFirstAspect {

    @Around("@annotation(aop)")
    public Object around(ProceedingJoinPoint joinPoint, MyFirstAop aop) throws Throwable {

        log.info("MyFirstAspect#around execute start");

        try {
            return joinPoint.proceed();
        } finally {
            log.info("MyFirstAspect#around execute end");
        }

    }

}
