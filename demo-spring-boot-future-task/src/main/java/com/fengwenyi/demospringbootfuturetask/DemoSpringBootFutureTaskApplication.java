package com.fengwenyi.demospringbootfuturetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-23
 */
@SpringBootApplication
@EnableAsync
public class DemoSpringBootFutureTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootFutureTaskApplication.class, args);
    }

}
