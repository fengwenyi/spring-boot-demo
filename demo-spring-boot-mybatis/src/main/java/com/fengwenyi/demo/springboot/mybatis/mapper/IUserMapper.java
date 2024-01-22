package com.fengwenyi.demo.springboot.mybatis.mapper;

import com.fengwenyi.demo.springboot.mybatis.entity.UserEntity;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-04-19
 */
public interface IUserMapper {

    List<UserEntity> queryAll();

}
