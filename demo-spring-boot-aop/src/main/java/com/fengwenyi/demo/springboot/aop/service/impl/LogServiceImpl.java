package com.fengwenyi.demo.springboot.aop.service.impl;

import com.fengwenyi.demo.springboot.aop.service.ILogService;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
@Service
public class LogServiceImpl implements ILogService {
    @Override
    public void errorLog(String type, String className, String methodName, String errMsg) {

    }

    @Override
    public void infoLog(String type, String className, String methodName, String data) {

    }
}
