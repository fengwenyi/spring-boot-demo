package com.fengwenyi.demospringbootredis.service;

import com.fengwenyi.demospringbootredis.DemoSpringBootRedisApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-10
 */
@Component
public class StringRedisServiceTests extends DemoSpringBootRedisApplicationTests {

    @Autowired
    private IStringRedisService stringRedisService;

    @Test
    void testSetGet() {
        String key = "test-key";
        String value = "test-value";
        stringRedisService.set(key, value);
        String getValue = stringRedisService.get(key);
        Assert.isTrue(value.equals(getValue), "StringRedisTemplate set() and get() exception");
    }

}
