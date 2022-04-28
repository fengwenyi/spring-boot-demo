package com.fengwenyi.demospringbootmybatisplus.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.demospringbootmybatisplus.dao.IGoodsDao;
import com.fengwenyi.demospringbootmybatisplus.entity.GoodsEntity;
import com.fengwenyi.demospringbootmybatisplus.repository.MPGoodsRepository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-28
 */
@Service
public class GoodsRepositoryImpl extends ServiceImpl<IGoodsDao, GoodsEntity> implements MPGoodsRepository {
}
