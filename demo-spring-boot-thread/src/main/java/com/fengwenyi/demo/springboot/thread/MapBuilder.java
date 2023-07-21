package com.fengwenyi.demo.springboot.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-12-03
 */
public class MapBuilder<T> {

    private Map<String, T> map = null;

    public static <T> MapBuilder<T> init() {
        MapBuilder<T> mapBuilder = new MapBuilder<T>();
        mapBuilder.map = new HashMap<>();
        return mapBuilder;
    }

    public MapBuilder<T> put(String key, T value) {
        if (Objects.isNull(map)) {
            return this;
        }
        map.put(key, value);
        return this;
    }

    public Map<String, T> build() {
        return map;
    }
}
