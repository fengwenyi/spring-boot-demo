package com.fengwenyi.demo.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-04-19
 */
@MapperScan("com.fengwenyi.demo.springboot.mybatis.mapper")
@SpringBootApplication
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }

}
