package com.fengwenyi.demospringbootcaffeine.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootcaffeine.vo.GoodsResponseVo;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-15
 */
public interface IGoodsService {
    ResultTemplate<GoodsResponseVo> get(String id);
}
