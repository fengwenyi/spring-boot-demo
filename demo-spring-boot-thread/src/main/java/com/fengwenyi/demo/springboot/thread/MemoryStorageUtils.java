package com.fengwenyi.demo.springboot.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-11
 */
public class MemoryStorageUtils {

    public static final ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();

    public static void set(String key, Object value) {
        map.put(key, value);
    }

    public static Object get(String key) {
        return map.get(key);
    }

}
