package com.fengwenyi.demospringbootcaffeine.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootcaffeine.repository.DataRepository;
import com.fengwenyi.demospringbootcaffeine.service.IGoodsService;
import com.fengwenyi.demospringbootcaffeine.vo.GoodsResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
@Service
@Slf4j
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public ResultTemplate<GoodsResponseVo> get(String id) {
        GoodsResponseVo responseVo = dataRepository.queryById(id);
        return ResultTemplate.success(responseVo);
    }


}
