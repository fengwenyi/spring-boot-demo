package com.fengwenyi.demospringbootcaffeine.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootcaffeine.service.IGoodsService;
import com.fengwenyi.demospringbootcaffeine.vo.GoodsResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping
    public ResultTemplate<GoodsResponseVo> get(String id) {
        return goodsService.get(id);
    }

}
