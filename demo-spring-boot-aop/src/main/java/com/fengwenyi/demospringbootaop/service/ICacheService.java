package com.fengwenyi.demospringbootaop.service;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
public interface ICacheService {

    Object get(String key, String cacheName);

    void put(String key, Object result, String cacheName);
}
