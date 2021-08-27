package com.fengwenyi.demospringbootaop.service.impl;

import com.fengwenyi.demospringbootaop.annotation.QueryData;
import com.fengwenyi.demospringbootaop.entity.TUserEntity;
import com.fengwenyi.demospringbootaop.service.IUserService;
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
