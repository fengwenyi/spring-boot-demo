package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.mybatis.MyBatisApplicationTests;
import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.springboot.mybatis.model.PageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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

    @Test
    public void testPage() {
        PageModel pageModel = new PageModel();
        pageModel.setCurrent(1L);
        pageModel.setPageSize(10);
        List<UserEntity> userEntityList = userMapper.pageByInterceptor(pageModel);
        System.out.println(JsonUtils.convertString(userEntityList));
    }

    @Test
    public void testQueryMapByName() {
        Map<Integer, UserEntity> map = userMapper.queryMapByName("张三");
        for (Map.Entry<Integer, UserEntity> entry : map.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), JsonUtils.convertString(entry.getValue()));
        }
    }
}
