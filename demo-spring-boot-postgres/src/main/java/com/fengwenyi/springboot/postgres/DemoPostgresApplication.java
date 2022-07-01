package com.fengwenyi.springboot.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-01
 */
@EnableJpaAuditing
@SpringBootApplication
public class DemoPostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPostgresApplication.class, args);
    }

}
