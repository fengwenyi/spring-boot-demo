package com.fengwenyi.demo.springboot.mybatis.service.impl;

import com.fengwenyi.api.result.PageTemplate;
import com.fengwenyi.demo.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.demo.springboot.mybatis.mapper.IUserMapper;
import com.fengwenyi.demo.springboot.mybatis.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-11-07
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public PageTemplate<UserEntity> getPage() {

        PageHelper.startPage(1, 1);
        List<UserEntity> list = userMapper.queryAll();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(list);

        return new PageTemplate<>((long) pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), (long) pageInfo.getPages(), pageInfo.getList());
    }
}
