package com.fengwenyi.springboot.mybatis.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.mybatis.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public ResultTemplate<?> getAll() {
        return ResultTemplate.success(userMapper.queryAll());
    }
}
