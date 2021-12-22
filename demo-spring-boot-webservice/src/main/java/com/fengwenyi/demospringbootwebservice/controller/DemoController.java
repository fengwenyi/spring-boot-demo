package com.fengwenyi.demospringbootwebservice.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringbootwebservice.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-22
 */
@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("/demo")
    public ResponseTemplate<String> demo() {
        demoService.hello();
        return ResponseTemplate.success();
    }

    @GetMapping("/template")
    public ResponseTemplate<String> template() {
        demoService.template();
        return ResponseTemplate.success();
    }

}
