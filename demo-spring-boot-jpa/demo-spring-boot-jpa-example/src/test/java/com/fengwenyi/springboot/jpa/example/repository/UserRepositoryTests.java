package com.fengwenyi.springboot.jpa.example.repository;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.jpa.example.DemoJpaApplicationTests;
import com.fengwenyi.springboot.jpa.example.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-15
 */
@Slf4j
public class UserRepositoryTests extends DemoJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        UserEntity query = new UserEntity();
        query.setUsername("zhangsan");
        Example<UserEntity> example = Example.of(query);

        UserEntity user = userRepository.findOne(example).orElse(null);
        log.info(JsonUtils.prettyPrint(user));
    }

    @Test
    public void testFindAllSort() {
        UserEntity query = new UserEntity();
        Example<UserEntity> example = Example.of(query);

        Sort sort = Sort.by(Sort.Direction.ASC, "createTime");
        // Sort sort = Sort.by(Sort.Direction.ASC, "create_time"); // 这样写会报错

        List<UserEntity> users = userRepository.findAll(example, sort);

        log.info(JsonUtils.prettyPrint(users));
    }

    @Test
    public void testFindAll() {
        UserEntity query = new UserEntity();
//        query.setNickname("%三%"); // 是不能这样写的
//        query.setNickname("三");
        query.setUsername("ZHANGSAN");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.ignoreCase()) // 忽略大小写
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("password") //忽略字段，即不管password是什么值都不加入查询条件
                ;
        Example<UserEntity> example = Example.of(query, matcher);
        List<UserEntity> users = userRepository.findAll(example);

        log.info(JsonUtils.prettyPrint(users));

        /*
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
                .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
                .withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
         */
    }

    @Test
    public void testFindAllExample() {
        UserEntity query = new UserEntity();
        query.setUsername("zhangsan");
        Example<UserEntity> example = Example.of(query);
        List<UserEntity> users = userRepository.findAll(example);

        log.info(JsonUtils.prettyPrint(users));
    }

}
