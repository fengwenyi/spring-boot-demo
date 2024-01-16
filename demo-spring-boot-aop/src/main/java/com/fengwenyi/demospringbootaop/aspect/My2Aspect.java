package com.fengwenyi.demospringbootaop.aspect;

import com.fengwenyi.demospringbootaop.annotation.MyAop;
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

    @Around("execution(* com.fengwenyi.demospringbootaop.controller.SampleController.myApi2(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

}
