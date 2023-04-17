package com.fengwenyi.springboot.mybatis.mapper;

import com.fengwenyi.springboot.mybatis.entity.UserEntity;
import com.fengwenyi.springboot.mybatis.model.PageModel;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-24
 */
//@Mapper
public interface UserMapper {

    int save(UserEntity user);

    List<UserEntity> queryAll();

    List<UserEntity> pageByInterceptor(PageModel pageModel);

    @MapKey("id")
    @Select("select * from t_user where name = #{name}")
    Map<Integer, UserEntity> queryMapByName(@Param("name") String name);
}
