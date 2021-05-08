package com.fengwenyi.demospringbootvalidated.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
@Data
@Accessors(chain = true)
public class GoodsAddRequestVo {

    @NotBlank(message = "商品名称不能为空")
    private String name;

    private String desc;

    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格不能小于0")
    private BigDecimal price;

    @NotNull(message = "商品数量不能为空")
    @Min(value = 0, message = "商品数量不能小于0")
    private Integer num;

}
