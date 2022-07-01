package com.fengwenyi.springboot.shardingjdbc.controller;

import com.fengwenyi.javalib.generate.IdUtils;
import com.fengwenyi.springboot.shardingjdbc.entity.OrderEntity;
import com.fengwenyi.springboot.shardingjdbc.repository.OrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-30
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/create")
    public void create(@RequestBody OrderEntity requestVo) {
        OrderEntity entity = new OrderEntity();
        entity.setId(System.currentTimeMillis());
        entity.setUserId(requestVo.getUserId());
        entity.setGoodsId(1L);
        entity.setAmount(new BigDecimal(1));
        entity.setState("TO_PAY");
        orderRepository.save(entity);
    }

}
