package com.fengwenyi.springboot.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-05
 */
@SpringBootApplication
@EnableAdminServer
public class DemoAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAdminServerApplication.class, args);
    }

}
