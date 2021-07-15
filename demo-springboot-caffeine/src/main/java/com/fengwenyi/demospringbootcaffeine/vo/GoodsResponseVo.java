package com.fengwenyi.demospringbootcaffeine.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
@Data
@Accessors(chain = true)
public class GoodsResponseVo {

    private String id;

    private String name;

    private BigDecimal price;

    private Integer stock;

}
