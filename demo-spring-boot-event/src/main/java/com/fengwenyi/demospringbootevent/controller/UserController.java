package com.fengwenyi.demospringbootevent.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringbootevent.event.MyPublisher;
import com.fengwenyi.demospringbootevent.vo.request.UserLoginRequestVo;
import com.fengwenyi.javalib.util.MdcUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-18
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private MyPublisher publisher;

    @Autowired
    public void setPublisher(MyPublisher publisher) {
        this.publisher = publisher;
    }

    @RequestMapping("/login")
    public ResponseTemplate<?> login(UserLoginRequestVo requestVo) {
        publisher.userLoginEvent(requestVo.getUsername());
        return ResponseTemplate.success();
    }

    @RequestMapping("/exception")
    public ResponseTemplate<?> exception(String msg) {
        MdcUtils.call("异常接口", msg);
        log.info("请求");
        publisher.alarm(msg);
        log.info("触发完成");
        return ResponseTemplate.fail();
    }

    @RequestMapping("/logout")
    public ResponseTemplate<?> logout(String uid) {
        log.info("用户登出请求-{}", uid);
        publisher.logout(uid);
        log.info("用户登出事件发布完成");
        return ResponseTemplate.success();
    }

}
