package com.fengwenyi.demospringbootsatoken.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/index")
    public ResponseTemplate<?> index() {
        return ResponseTemplate.success();
    }


}
