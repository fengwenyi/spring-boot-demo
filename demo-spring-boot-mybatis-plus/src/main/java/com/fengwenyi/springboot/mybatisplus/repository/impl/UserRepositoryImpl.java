package com.fengwenyi.springboot.mybatisplus.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.springboot.mybatisplus.entity.UserEntity;
import com.fengwenyi.springboot.mybatisplus.mapper.IUserMapper;
import com.fengwenyi.springboot.mybatisplus.repository.MPUserRepository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-28
 */
@Service
public class UserRepositoryImpl
        extends ServiceImpl<IUserMapper, UserEntity>
        implements MPUserRepository {
}
