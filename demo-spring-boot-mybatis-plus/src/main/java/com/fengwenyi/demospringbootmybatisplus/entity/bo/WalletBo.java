package com.fengwenyi.demospringbootmybatisplus.entity.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-06
 */
@Data
public class WalletBo {

    private BigDecimal alipay;

    private BigDecimal wechat;

}
