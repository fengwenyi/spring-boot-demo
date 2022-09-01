package com.fengwenyi.springboot.example.aspect;

import com.fengwenyi.springboot.example.parser.SpElParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-31
 */
public class BaseAspect {

    protected String getKey(String key, ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameterNames.length; i++) {
            parameterNames[i] = parameters[i].getName();
        }
        return SpElParser.getKey(key, parameterNames, joinPoint.getArgs());
    }

}
