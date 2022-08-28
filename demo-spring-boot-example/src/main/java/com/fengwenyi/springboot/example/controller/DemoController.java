package com.fengwenyi.springboot.example.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springboot.example.vo.request.FormParamRequestVo;
import com.fengwenyi.springboot.example.vo.request.PostParamVerifyRequestVo;
import com.fengwenyi.springboot.example.vo.response.StringNull2BlankResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/postParamVerify")
    public ResultTemplate<Void> postParamVerify(@RequestBody @Validated PostParamVerifyRequestVo requestVo) {
        return ResultTemplate.success();
    }

    @GetMapping("/stringNull2Blank")
    public ResultTemplate<StringNull2BlankResponseVo> stringNullResponse() {
        return ResultTemplate.success(
                new StringNull2BlankResponseVo()
        );
    }

    @RequestMapping("/formParam")
    public ResultTemplate<Void> formParam(FormParamRequestVo requestVo) {
        log.info("formParam: [{}]", JsonUtils.convertString(requestVo));
        return ResultTemplate.success();
    }

}
