package com.fengwenyi.demospringbootcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
@SpringBootApplication
@EnableCaching
public class DemoSpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootCacheApplication.class, args);
    }

}
