package com.fengwenyi.springboot.postgres.repository;

import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.postgres.DemoPostgresApplicationTests;
import com.fengwenyi.springboot.postgres.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-01
 */
@Slf4j
public class UserRepositoryTests extends DemoPostgresApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        UserEntity entity = new UserEntity()
                .setUsername("zhangsan")
                .setPassword("123456")
                .setNickname("张三")
                .setAge(18)
                .setAddress("成都")
                ;
        UserEntity user = userRepository.save(entity);
        log.info("test user save result: [{}]", JsonUtils.convertString(user));
    }

}
