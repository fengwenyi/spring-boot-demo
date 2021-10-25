package com.fengwenyi.demospringbootapiresult.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/demo")
    public ResponseTemplate<Void> demo() {
        return ResponseTemplate.success();
    }

}
