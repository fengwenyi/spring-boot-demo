package com.fengwenyi.springboot.swagger2;

import com.fengwenyi.apistarter.EnableApiStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-21
 */
@SpringBootApplication
//@EnableApiStarter
//@EnableSwagger2
public class DemoSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoSwagger2Application.class, args);
    }

}
