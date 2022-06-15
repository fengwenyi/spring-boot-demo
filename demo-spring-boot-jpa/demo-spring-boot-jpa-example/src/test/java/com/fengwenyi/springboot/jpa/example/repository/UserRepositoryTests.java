package com.fengwenyi.springboot.jpa.example.repository;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.jpa.example.DemoJpaApplicationTests;
import com.fengwenyi.springboot.jpa.example.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

}
