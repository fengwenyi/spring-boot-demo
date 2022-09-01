package com.fengwenyi.springboot.example.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.example.vo.request.TicketSellRequestVo;
import com.fengwenyi.springboot.example.vo.response.TicketSellResponseVo;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-01
 */
public interface TicketService {

    ResultTemplate<TicketSellResponseVo> sell(TicketSellRequestVo requestVo);

    ResultTemplate<List<String>> list();

}
