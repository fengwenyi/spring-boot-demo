package com.fengwenyi.demospringbootmybatisplus.repository;

import com.fengwenyi.demospringbootmybatisplus.DemoSpringBootMyBatisPlusApplicationTests;
import com.fengwenyi.demospringbootmybatisplus.entity.UserEntity;
import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-06
 */
@Slf4j
public class UserRepositoryTests extends DemoSpringBootMyBatisPlusApplicationTests {

    @Autowired
    private MPUserRepository mpUserRepository;

    @Test
    public void testJson() {
        List<UserEntity> list = mpUserRepository.list();
        log.info(JsonUtils.convertString(list));
    }

}
