package com.fengwenyi.springboot.dynamictp;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-08
 */
@EnableDynamicTp
@SpringBootApplication
public class DynamicTPApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicTPApplication.class, args);
    }

}
