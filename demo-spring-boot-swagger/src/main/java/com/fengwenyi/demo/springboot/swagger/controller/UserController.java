package com.fengwenyi.demo.springboot.swagger.controller;

import com.fengwenyi.demo.springboot.swagger.model.UserDto;
import com.fengwenyi.demo.springboot.swagger.model.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-03-25
 */
@Tag(name = "User", description = "用户相关API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "查询用户信息接口", description = "用户信息")
    @GetMapping("/getUser")
    public UserVo getUser(UserDto userDto) {
        return null;
    }

}
