package com.fengwenyi.demospringbootredis.service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
public interface IStringRedisService {

    void set(String key, String value);

    String get(String key);

}
