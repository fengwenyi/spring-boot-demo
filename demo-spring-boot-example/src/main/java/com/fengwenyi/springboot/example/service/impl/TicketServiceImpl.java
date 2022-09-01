package com.fengwenyi.springboot.example.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.javalib.generate.IdUtils;
import com.fengwenyi.springboot.example.service.TicketService;
import com.fengwenyi.springboot.example.vo.request.TicketSellRequestVo;
import com.fengwenyi.springboot.example.vo.response.TicketSellResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-01
 */
@Service
public class TicketServiceImpl implements TicketService {

    private static final Set<String> TICKET = new HashSet<>();
    private static final ConcurrentMap<String, String> TICKET_SELL = new ConcurrentHashMap<>();

    static {

        for (int i = 0; i < 10; i++) {
            TICKET.add(IdUtils.genId());
        }

    }

    @Override
    public ResultTemplate<TicketSellResponseVo> sell(TicketSellRequestVo requestVo) {
        int size = TICKET.size();
        if (TICKET.isEmpty()) {
            return ResultTemplate.fail("无票");
        }

        String userId = requestVo.getUserId();

        String userTicketNo = TICKET_SELL.get(userId);
        if (StringUtils.hasText(userTicketNo)) {
            return ResultTemplate.fail("已购票");
        }

        String ticketNo = (String) TICKET.toArray()[size - 1];
        TICKET.remove(ticketNo);

        TICKET_SELL.put(userId, ticketNo);

        return ResultTemplate.success(new TicketSellResponseVo().setTicketNo(ticketNo));
    }

    @Override
    public ResultTemplate<List<String>> list() {
        return ResultTemplate.success(new ArrayList<>(TICKET));
    }
}
