package com.fengwenyi.demospringbootevent.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootevent.MyPublisher;
import com.fengwenyi.demospringbootevent.vo.request.UserLoginRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private MyPublisher publisher;

    @Autowired
    public void setPublisher(MyPublisher publisher) {
        this.publisher = publisher;
    }

    @RequestMapping("/login")
    public ResultTemplate<?> login(UserLoginRequestVo requestVo) {
        publisher.userLoginEvent(requestVo.getUsername());
        return ResultTemplate.success();
    }

}
