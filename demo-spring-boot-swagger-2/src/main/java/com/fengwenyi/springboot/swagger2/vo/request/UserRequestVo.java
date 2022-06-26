package com.fengwenyi.springboot.swagger2.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-26
 */
@ApiModel(description = "用户")
@Data
public class UserRequestVo {

    @ApiModelProperty(value = "用户名", example = "123@example.com")
    public String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty(value = "类型", allowableValues = "first, second, third")
    private Integer type;

    //@ApiModelProperty(name = "类型2", dataType = "Integer", allowableValues = "range[1, 5]")
    private Integer type2;

}
