package com.fengwenyi.springboot.example.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.example.vo.request.PostParamVerifyRequestVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/postParamVerify")
    public ResultTemplate<Void> postParamVerify(@RequestBody @Validated PostParamVerifyRequestVo requestVo) {
        return ResultTemplate.success();
    }

}
