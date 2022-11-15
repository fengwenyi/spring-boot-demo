package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.springboot.mybatis.model.PageModel;
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

    List<UserEntity> pageByInterceptor(PageModel pageModel);
}
