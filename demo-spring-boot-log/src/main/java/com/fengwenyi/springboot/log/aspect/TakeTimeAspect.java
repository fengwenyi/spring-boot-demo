package com.fengwenyi.springboot.log.aspect;

import com.fengwenyi.springboot.log.annotation.TakeTime;
import com.fengwenyi.springboot.log.parser.SpElParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Erwin Feng
 * @since 2020-10-09
 */
@Component
@Aspect
@Slf4j
public class TakeTimeAspect {

    @Around("@annotation(takeTime)")
    public Object around(ProceedingJoinPoint joinPoint, TakeTime takeTime) throws Throwable {
        String logKey = takeTime.logKey();
        String bizId = getKey(takeTime.bizId(), joinPoint);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        log.info("[{}], [{}], time: [{}]ms", logKey, bizId, stopWatch.getTotalTimeMillis());
        return result;
    }

    private String getKey(String key, ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameterNames.length; i++) {
            parameterNames[i] = parameters[i].getName();
        }
        return SpElParser.getKey(key, parameterNames, joinPoint.getArgs());
    }
}
