package com.fengwenyi.springboot.jpa.example.service;

import com.fengwenyi.apistarter.utils.Asserts;
import com.fengwenyi.springboot.jpa.example.entity.UserEntity;
import com.fengwenyi.springboot.jpa.example.repository.UserRepository;
import com.fengwenyi.springboot.jpa.example.vo.request.LoginRequestVo;
import com.fengwenyi.springboot.jpa.example.vo.request.UserQueryRequestVo;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-21
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<?> queryPage(UserQueryRequestVo requestVo) {

        return null;
    }

    public String login(LoginRequestVo requestVo) {
        UserEntity userQuery = new UserEntity();
        userQuery.setUsername(requestVo.getUsername());
        Example<UserEntity> userExample = Example.of(userQuery);
        Optional<UserEntity> userOption = userRepository.findOne(userExample);
        if (userOption.isPresent()) {
            UserEntity user = userOption.get();
            if (user.getPassword().equals(requestVo.getPassword())) {
                return "登录成功";
            } else {
                Asserts.fail("密码错误");
            }
        } else {
            Asserts.fail("用户名错误");
        }
        return "登录失败";
    }

}
