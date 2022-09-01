package com.fengwenyi.springboot.example.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.example.service.TicketService;
import com.fengwenyi.springboot.example.annotation.RateLimit;
import com.fengwenyi.springboot.example.vo.request.TicketSellRequestVo;
import com.fengwenyi.springboot.example.vo.response.TicketSellResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-01
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private TicketService ticketService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket/sell")
    @RateLimit(value = "api-ticket-sell", permitsPerSecond = 1, timeout = 100)
    public ResultTemplate<TicketSellResponseVo> ticketSell(@RequestBody @Validated TicketSellRequestVo requestVo) {
        return ticketService.sell(requestVo);
    }

    @PostMapping("/ticket/list")
    @RateLimit(value = "api-ticket-list", permitsPerSecond = 1, timeout = 0)
    public ResultTemplate<List<String>> ticketList() {
        return ticketService.list();
    }

}
