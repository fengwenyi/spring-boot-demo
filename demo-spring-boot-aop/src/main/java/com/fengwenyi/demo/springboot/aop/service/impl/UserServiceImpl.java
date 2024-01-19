package com.fengwenyi.demo.springboot.aop.service.impl;

import com.fengwenyi.demo.springboot.aop.annotation.QueryData;
import com.fengwenyi.demo.springboot.aop.entity.TUserEntity;
import com.fengwenyi.demo.springboot.aop.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2020/9/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    @QueryData(key = "#id", cacheName = "USER", needLog = true)
    public TUserEntity queryById(String id) {
        return null;
    }
}
