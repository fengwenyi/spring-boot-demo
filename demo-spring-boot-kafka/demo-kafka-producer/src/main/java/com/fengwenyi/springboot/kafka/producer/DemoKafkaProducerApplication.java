package com.fengwenyi.springboot.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@SpringBootApplication
@EnableKafka
public class DemoKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaProducerApplication.class, args);
    }

}
