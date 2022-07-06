package com.fengwenyi.demospringbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.demospringbootmybatisplus.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-06
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
}
