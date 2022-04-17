package com.fengwenyi.demospringbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengwenyi.demospringbootmybatisplus.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-17
 */
@Mapper
public interface IGoodsDao extends BaseMapper<GoodsEntity> {

    /**
     * 根据商品名称查询
     */
    List<GoodsEntity> queryByName(@Param("name") String name);

}
