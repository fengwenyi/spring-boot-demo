package com.fengwenyi.springboot.rabbitmq.model;

import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-21
 */
@Data
@Accessors(chain = true)
public class Order {

    private String orderId;
    private Integer orderStatus;
    private Integer payStatus;
    private String buyerName;
    private String buyerAddress;
    private String buyerPhone;
    private BigDecimal orderAmount;
    private LocalDateTime createTime;

    public String toJson() {
        return JsonUtils.convertString(this);
    }

    public static Order to(String json) {
        return JsonUtils.convertObject(json, Order.class);
    }

}
