package com.fengwenyi.demospringbootvalidated.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootvalidated.vo.UserRegisterRequestVo;
import com.fengwenyi.demospringbootvalidated.vo.UserRegisterResponseVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/api/user/v1")
public class ApiUserV1Controller {

    @PostMapping("/register")
    public ResultTemplate<UserRegisterResponseVo> register(@RequestBody @Validated UserRegisterRequestVo requestVo) {
        return ResultTemplate.success();
    }

}
