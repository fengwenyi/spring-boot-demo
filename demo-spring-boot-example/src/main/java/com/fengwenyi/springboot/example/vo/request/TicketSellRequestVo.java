package com.fengwenyi.springboot.example.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-01
 */
@Data
public class TicketSellRequestVo {

    @NotBlank(message = "用户ID不能为空")
    private String userId;

}
