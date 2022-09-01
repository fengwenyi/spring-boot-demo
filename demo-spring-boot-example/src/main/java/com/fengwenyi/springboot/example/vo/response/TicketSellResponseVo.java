package com.fengwenyi.springboot.example.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-01
 */
@Data
@Accessors(chain = true)
public class TicketSellResponseVo {

    private String ticketNo;

}
