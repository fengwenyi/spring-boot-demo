package com.fengwenyi.demospringbootredis.controller;

import com.fengwenyi.demospringbootredis.model.UserModel;
import com.fengwenyi.demospringbootredis.service.IMethodCacheService;
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

    private final IMethodCacheService methodCacheService;

    public UserController(IMethodCacheService methodCacheService) {
        this.methodCacheService = methodCacheService;
    }

    @GetMapping("/{id}")
    public UserModel get(@PathVariable String id) {
        return methodCacheService.queryUser(id);
    }

    @GetMapping("/list")
    public List<UserModel> getList() {
        return methodCacheService.queryUserList();
    }

    @GetMapping("/name")
    public String getName(String id) {
        return methodCacheService.queryUserName(id);
    }

}
