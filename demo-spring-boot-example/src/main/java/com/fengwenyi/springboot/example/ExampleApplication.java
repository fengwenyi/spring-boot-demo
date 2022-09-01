package com.fengwenyi.springboot.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@Slf4j
@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SpringApplication.run(ExampleApplication.class, args);
        Duration duration = Duration.ofNanos(System.nanoTime() - startTime);
        long millis = duration.toMillis();
        log.info("[{}]ms", millis);
    }

}
