package com.fengwenyi.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-24
 */
@MapperScan("com.fengwenyi.springboot.mybatis.mapper")
@SpringBootApplication
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }

}
