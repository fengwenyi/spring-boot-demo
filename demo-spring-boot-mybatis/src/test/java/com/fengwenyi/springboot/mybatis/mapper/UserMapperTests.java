package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.mybatis.MyBatisApplicationTests;
import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-24
 */
public class UserMapperTests extends MyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAdd() {
        int result = userMapper.save(new UserEntity().setName("张三").setAge(20));
        System.out.println(result);
    }

    @Test
    public void testQueryAll() {
        List<UserEntity> userEntityList = userMapper.queryAll();
        System.out.println(JsonUtils.convertString(userEntityList));;
    }
}
