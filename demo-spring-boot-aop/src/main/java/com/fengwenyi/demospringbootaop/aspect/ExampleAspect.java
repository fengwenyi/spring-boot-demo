package com.fengwenyi.demospringbootaop.aspect;

import com.fengwenyi.demospringbootaop.annotation.QueryData;
import com.fengwenyi.demospringbootaop.parser.SpelParser;
import com.fengwenyi.demospringbootaop.service.ICacheService;
import com.fengwenyi.demospringbootaop.service.ILogService;
import com.fengwenyi.demospringbootaop.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Erwin Feng
 * @since 2020/9/12
 */
@Slf4j
@Aspect
@Component
public class ExampleAspect {

    @Autowired
    private ICacheService iCacheService;

    @Autowired
    private ILogService iLogService;

    @Order(100001)
    @Around("execution(* com.fengwenyi.demospringbootaop.controller.*.*(..))")
    public Object logExecutionTime1(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        log.info("ExampleAspect#around execute start");

        try {

            return joinPoint.proceed();

        } finally {


            long endTime = System.nanoTime();

            double spendTime = (endTime - startTime) / 1000_1000d;

            log.info("ExampleAspect#around execute end");

            log.info("url：{}, 耗时：{}毫秒", "", spendTime);

        }
    }


    @Around("@annotation(queryData)")
    public Object logExecutionTime2(ProceedingJoinPoint joinPoint, QueryData queryData) throws Throwable {

        String key = getKey(queryData.key(), joinPoint);
        String cacheName = queryData.cacheName();
        boolean needLog = queryData.needLog();

        // 从缓存中获取
        Object cacheResult = iCacheService.get(key, cacheName);
        if (cacheResult != null) {
            return cacheResult;
        }

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            if (needLog) {
                iLogService.errorLog("1", UserServiceImpl.class.getSimpleName(), "", e.getMessage());
            }
        }

        if (needLog) {
            iLogService.errorLog("1", UserServiceImpl.class.getSimpleName(), "", result.toString());
        }

        iCacheService.put(key, result, cacheName);

        return result;
    }

    private String getKey(String key, ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameterNames.length; i++) {
            parameterNames[i] = parameters[i].getName();
        }
        return SpelParser.getKey(key, parameterNames, joinPoint.getArgs());
    }


}
