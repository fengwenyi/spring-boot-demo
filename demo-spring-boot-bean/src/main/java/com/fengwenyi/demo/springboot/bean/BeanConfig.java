package com.fengwenyi.demo.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-06
 */
@Configuration
public class BeanConfig {

    @Bean
    public User user() {

        User user = new User(1, "张三");

        user.setId(2);
        user.setName("李四");

        return user;
    }

}
