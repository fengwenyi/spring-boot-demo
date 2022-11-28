package com.fengwenyi.springboot.mybatisplus.controller;

import com.fengwenyi.api.result.ListTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.mybatisplus.entity.UserEntity;
import com.fengwenyi.springboot.mybatisplus.repository.MPUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final MPUserRepository mpUserRepository;

    public UserController(MPUserRepository mpUserRepository) {
        this.mpUserRepository = mpUserRepository;
    }

    @GetMapping("/all")
    public ResultTemplate<ListTemplate<UserEntity>> getAll() {
        return ResultTemplate.success(
                new ListTemplate<UserEntity>().setContent(
                        mpUserRepository.list()
                )
        );
    }

}
