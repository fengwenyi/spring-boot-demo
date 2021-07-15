package com.fengwenyi.demospringbootcaffeine.repository;

import com.fengwenyi.demospringbootcaffeine.vo.GoodsResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
@Repository
@Slf4j
//@CacheConfig(cacheNames = {"goods"})
public class DataRepository {

//    @Cacheable(value = "goods", key = "#id")
    @Cacheable(key = "#id")
    public GoodsResponseVo queryById(String id) {
        log.info(">>>>>>>>>>>查询数据-----------");
        return new GoodsResponseVo()
                .setId(id)
                .setName("iPhone 11")
                .setPrice(new BigDecimal(6666))
                .setStock(1000);
    }

}
