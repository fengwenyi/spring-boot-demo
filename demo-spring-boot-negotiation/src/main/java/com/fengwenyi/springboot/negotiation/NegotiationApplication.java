package com.fengwenyi.springboot.negotiation;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-11
 */
@SpringBootApplication
@RestController
public class NegotiationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NegotiationApplication.class, args);
    }

    @GetMapping("/")
    public ResponseTemplate<String> hello() {
        return ResponseTemplate.success();
    }
}
