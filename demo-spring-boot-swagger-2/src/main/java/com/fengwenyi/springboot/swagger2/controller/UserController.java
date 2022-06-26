package com.fengwenyi.springboot.swagger2.controller;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.swagger2.vo.request.UserRequestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-26
 */
@Api(tags = "用户API")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

//    @ApiOperation(value = "注册", notes = "用户注册", httpMethod = "POST")
    @ApiOperation(value = "注册", notes = "用户注册")
    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserRequestVo requestVo) {
        log.info("请求参数：[{}]", JsonUtils.convertString(requestVo));
    }

}
