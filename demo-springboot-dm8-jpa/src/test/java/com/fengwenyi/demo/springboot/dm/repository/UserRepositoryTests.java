package com.fengwenyi.demo.springboot.dm.repository;

import com.fengwenyi.demo.springboot.dm.Dm8ApplicationTests;
import com.fengwenyi.demo.springboot.dm.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-03-30
 */
public class UserRepositoryTests extends Dm8ApplicationTests {

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void testCRUD() {
//        UserEntity userEntity = add();
//        System.out.println(userEntity);

        List<UserEntity> userEntityList = query();
        for (UserEntity userEntity : userEntityList) {
            System.out.println(userEntity);
        }

    }

    private UserEntity add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        userEntity.setAge(18);
        userRepository.save(userEntity);
        return userEntity;
    }

    private List<UserEntity> query() {
        return userRepository.findAll();
    }

}
