package com.fengwenyi.demospringbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fengwenyi.demospringbootmybatisplus.DemoSpringBootMyBatisPlusApplicationTests;
import com.fengwenyi.demospringbootmybatisplus.entity.GoodsEntity;
import com.fengwenyi.javalib.convert.JsonUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品 dao 测试
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-17
 */
@Slf4j
@Component
public class GoodsTest extends DemoSpringBootMyBatisPlusApplicationTests {

    @Autowired
    private IGoodsDao goodsDao;

    @Test
    public void queryByName() {
        List<GoodsEntity> list = goodsDao.queryByName("Redmi");
        log.info(JsonUtils.prettyPrint(list));
/*
==>  Preparing: select * from t_goods t where t.name like concat('%', ?, '%')
==> Parameters: Redmi(String)
<==    Columns: id, create_date_time, create_user_id, create_user_name, update_date_time, update_user_id, update_user_name, enabled_state, deleted_state, name, price
<==        Row: 1, 2022-04-17 22:16:26, null, null, null, null, null, 1, 0, Redmi K40s, 2199.00
<==      Total: 1
 */
    }

    @Test
    public void selectList() {
        List<GoodsEntity> list = goodsDao.selectList(
                new LambdaQueryWrapper<GoodsEntity>()
                        .like(GoodsEntity::getName, "Redmi")
        );
        log.info(JsonUtils.prettyPrint(list));
/*
==>  Preparing: SELECT id,name,price,enabled_state,deleted_state,create_date_time,create_user_id,create_user_name,update_date_time,update_user_id,update_user_name FROM t_goods WHERE deleted_state=0 AND (name LIKE ?)
==> Parameters: %Redmi%(String)
<==    Columns: id, name, price, enabled_state, deleted_state, create_date_time, create_user_id, create_user_name, update_date_time, update_user_id, update_user_name
<==        Row: 1, Redmi K40s, 2199.00, 1, 0, 2022-04-17 22:16:26, null, null, null, null, null
<==      Total: 1
*/
    }

    @Test
    public void pageHelper() {
        Page<Object> pageRequest = PageHelper.startPage(1, 1);
        List<GoodsEntity> list = goodsDao.selectList(null);
        log.info("page: [{}]", pageRequest);
        log.info("page list: [{}]", JsonUtils.convertString(list));
    }

}
