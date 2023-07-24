package com.fengwenyi.demospringbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.demospringbootmybatisplus.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-07-24
 */
@Mapper
public interface ILogDao extends BaseMapper<LogEntity> {
}
