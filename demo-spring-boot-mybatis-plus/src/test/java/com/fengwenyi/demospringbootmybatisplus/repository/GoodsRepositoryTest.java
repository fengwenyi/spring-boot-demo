package com.fengwenyi.demospringbootmybatisplus.repository;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengwenyi.apistarter.constant.EnabledState;
import com.fengwenyi.demospringbootmybatisplus.DemoSpringBootMyBatisPlusApplicationTests;
import com.fengwenyi.demospringbootmybatisplus.entity.GoodsEntity;
import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-28
 */
//@Componentnent
@Slf4j
public class GoodsRepositoryTest extends DemoSpringBootMyBatisPlusApplicationTests {

    @Autowired
    private MPGoodsRepository mpGoodsRepository;

    @Test
    public void initData() {
        GoodsEntity goods = new GoodsEntity()
                .setName("Redmi K50")
                .setPrice(new BigDecimal("2599"))
                ;
        goods.setEnabledState(EnabledState.Y);
        boolean result = mpGoodsRepository.save(goods);
        Assert.isTrue(result, "商户数据添加失败");
    }

    @Test
    public void page() {
        Page<?> pageRequest = Page.of(1, 1);
        IPage<GoodsEntity> page = mpGoodsRepository.page(
                new Page<>(1, 1),
                null
        );
        log.info("goods page: [{}]", JsonUtils.convertString(page));
    }

    @Test
    public void list() {
        List<GoodsEntity> list = mpGoodsRepository.list();
        log.info("goods list: [{}]", JsonUtils.convertString(list));
    }

    @Test
    public void testUpdateWrapper() {
        LambdaUpdateWrapper<GoodsEntity> updateWrapper = //new LambdaUpdateWrapper<GoodsEntity>()
                Wrappers.lambdaUpdate(GoodsEntity.class)
                .set(GoodsEntity::getEnabledState, false)
                .set(GoodsEntity::getPrice, 1999)
                .eq(GoodsEntity::getId, 1)
                ;
        //updateWrapper.getSqlSet()
        log.info("updateWrapper: [{}]", updateWrapper.getSqlSet());
        mpGoodsRepository.update(updateWrapper);
//        new LambdaUpdateChainWrapper<>(mpGoodsRepository.getBaseMapper())
//                .set(GoodsEntity::getEnabledState, true)
//                .eq(GoodsEntity::getId, 1)
//                .update();
    }

}
