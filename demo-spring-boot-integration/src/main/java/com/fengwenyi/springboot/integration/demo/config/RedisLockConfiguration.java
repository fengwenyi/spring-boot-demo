package com.fengwenyi.springboot.integration.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

import javax.annotation.Resource;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-19
 */
@Configuration
public class RedisLockConfiguration {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisLockRegistry redisLockRegistry() {
        return new RedisLockRegistry(redisConnectionFactory, "demo-integration-redis");
    }

}
