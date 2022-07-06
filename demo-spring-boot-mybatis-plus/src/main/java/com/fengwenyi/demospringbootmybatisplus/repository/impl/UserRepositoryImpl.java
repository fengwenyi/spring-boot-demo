package com.fengwenyi.demospringbootmybatisplus.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.demospringbootmybatisplus.dao.UserDao;
import com.fengwenyi.demospringbootmybatisplus.entity.UserEntity;
import com.fengwenyi.demospringbootmybatisplus.repository.MPUserRepository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-06
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<UserDao, UserEntity> implements MPUserRepository {
}
