package com.fengwenyi.demospringbootdruid.controller;

import com.fengwenyi.demospringbootdruid.model.UserModel;
import com.fengwenyi.demospringbootdruid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Erwin Feng
 * @since 2019/8/26 09:46
 */
@RestController
public class ExampleController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/add")
    public Object add() {
        return userRepository.save(
                new UserModel()
                        .setId(UUID.randomUUID().toString())
                        .setUsername("Zhangsan").setAge(20));
    }

}
