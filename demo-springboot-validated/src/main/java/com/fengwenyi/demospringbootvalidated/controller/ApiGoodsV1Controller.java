package com.fengwenyi.demospringbootvalidated.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootvalidated.vo.GoodsAddRequestVo;
import com.fengwenyi.demospringbootvalidated.vo.GoodsAddResponseVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/api/goods/v1")
public class ApiGoodsV1Controller {

    @PostMapping("/add")
    public ResultTemplate<GoodsAddResponseVo> add(@RequestBody @Validated GoodsAddRequestVo requestVo) {
        return ResultTemplate.success();
    }

}
