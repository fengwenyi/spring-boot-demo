package com.fengwenyi.demospringbootaop.service;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
public interface ILogService {

    void errorLog(String type, String className, String methodName, String errMsg);

    void infoLog(String type, String className, String methodName, String data);

}
