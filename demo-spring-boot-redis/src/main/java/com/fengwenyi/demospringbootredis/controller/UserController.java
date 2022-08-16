package com.fengwenyi.demospringbootredis.controller;

import com.fengwenyi.demospringbootredis.model.UserModel;
import com.fengwenyi.demospringbootredis.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserModel get(@PathVariable String id) {
        return userService.queryUser(id);
    }

    @GetMapping("/list")
    public List<UserModel> getList() {
        return userService.queryUserList();
    }

    @GetMapping("/name")
    public String getName(String id) {
        return userService.queryUserName(id);
    }

}
