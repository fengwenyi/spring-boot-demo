package com.fengwenyi.springboot.example.aspect;

import com.fengwenyi.javalib.net.RequestUtils;
import com.fengwenyi.springboot.example.annotation.BizLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-14
 */
@Aspect
@Component
@Slf4j
public class BizLockAspect {

    @Around("@annotation(bizLock)")
    public Object around(ProceedingJoinPoint joinPoint, BizLock bizLock) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String postData = null;
        try {
            postData = RequestUtils.getPostData(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(postData);

//        HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse()


        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
