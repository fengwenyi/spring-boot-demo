package com.fengwenyi.demo.springboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-16
 */
@Aspect
@Component
public class My2Aspect {

    @Around("execution(* com.fengwenyi.demo.springboot.aop.controller.SampleController.myApi2(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

}
