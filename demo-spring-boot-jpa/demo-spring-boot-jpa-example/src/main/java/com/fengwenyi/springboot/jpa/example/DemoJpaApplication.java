package com.fengwenyi.springboot.jpa.example;

import com.fengwenyi.apistarter.EnableApiStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-30
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableApiStarter
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }

}
