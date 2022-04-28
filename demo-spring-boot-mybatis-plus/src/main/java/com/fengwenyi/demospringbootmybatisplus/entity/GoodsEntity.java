package com.fengwenyi.demospringbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fengwenyi.demospringbootmybatisplus.base.BaseBizEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_goods")
public class GoodsEntity extends BaseBizEntity {

    private String name;

    private BigDecimal price;

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
