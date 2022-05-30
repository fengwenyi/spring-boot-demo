package com.fengwenyi.springboot.jpa.example.service;

import com.fengwenyi.springboot.jpa.example.DemoJpaApplicationTests;
import com.fengwenyi.springboot.jpa.example.vo.request.LoginRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-30
 */
@Slf4j
@Component
public class UserServiceTest extends DemoJpaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        LoginRequestVo requestVo = new LoginRequestVo();
        requestVo.setUsername("zhangsan");
        requestVo.setPassword("123456");
        String login = userService.login(requestVo);
        log.info("login result: [{}]", login);
    }

}
