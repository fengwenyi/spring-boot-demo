package com.fengwenyi.demo.springboot.mybatis.service;

import com.fengwenyi.api.result.PageTemplate;
import com.fengwenyi.demo.springboot.mybatis.MyBatisApplicationTests;
import com.fengwenyi.demo.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.javalib.convert.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-07
 */
public class UserServiceTests extends MyBatisApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void testGetPage() {

        PageTemplate<UserEntity> page = userService.getPage();
        System.out.println(JsonUtils.prettyPrint(page));

    }

}
