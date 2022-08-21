package com.fengwenyi.springboot.rabbitmq.controller;

import com.fengwenyi.springboot.rabbitmq.config.RabbitMQConfig;
import com.fengwenyi.springboot.rabbitmq.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-20
 */
@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(String key, String msg) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_TOPIC_EXCHANGE, key, msg);
        return "发送成功";
    }

    @GetMapping("/sendDelayMsg/{time}/{name}")
    public String sendDelayMsg(@PathVariable("time") Integer time, @PathVariable("name") String name) {
        Order order = new Order();
        //订单未完成
        order.setOrderStatus(0);
        //未付款
        order.setPayStatus(0);
        order.setBuyerName(name);
        order.setBuyerAddress("湖南长沙");
        order.setBuyerPhone("手机号");
        order.setOrderAmount(BigDecimal.ZERO);
        order.setCreateTime(LocalDateTime.now());
        order.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
        //第一个参数是前面RabbitMqConfig的交换机名称 第二个参数的路由名称 第三个参数是传递的参数 第四个参数是配置属性
        this.rabbitTemplate.convertAndSend(
                "delay_exchange",
                "delay_key",
                order.toJson(),
                message -> {
                    //配置消息的过期时间
                    message.getMessageProperties().setDelay(time);
                    return message;
                }
        );
        return "创建订单成功";
    }

}
