package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-24
 */
//@Mapper
public interface UserMapper {

    int save(UserEntity user);

    List<UserEntity> queryAll();

}
