package com.fengwenyi.demospringbootswagger3.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootswagger3.vo.UserAddRequestVo;
import com.fengwenyi.demospringbootswagger3.vo.UserAddResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-18
 */
@RestController
@Api(tags = "Demo")
public class ApiDemoV1Controller {

    @ApiOperation("添加用户")
    @PostMapping("/userAdd")
    public ResultTemplate<UserAddResponseVo> userAdd(UserAddRequestVo requestVo) {

        UserAddResponseVo responseVo = new UserAddResponseVo();
        BeanUtils.copyProperties(requestVo, responseVo);

        return ResultTemplate.success(responseVo);
    }

}
