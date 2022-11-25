package com.fengwenyi.springboot.mybatis.controller;

import com.fengwenyi.api.result.ListTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.springboot.mybatis.mapper.IUserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserMapper userMapper;

//    public UserController(IUserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @GetMapping("/all")
    public ResultTemplate<ListTemplate<UserEntity>> getAll() {
        List<UserEntity> entityList = userMapper.queryAll();
        return ResultTemplate.success(new ListTemplate<UserEntity>().setContent(entityList));
    }

}
