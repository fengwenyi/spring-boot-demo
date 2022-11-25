package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.springboot.mybatis.entity.UserEntity;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-25
 */
public interface IUserMapper {

    int save(UserEntity user);

    List<UserEntity> queryAll();

}
