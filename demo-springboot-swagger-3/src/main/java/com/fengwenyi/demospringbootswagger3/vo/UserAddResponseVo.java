package com.fengwenyi.demospringbootswagger3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-18
 */
@Schema
@Data
public class UserAddResponseVo {

    @Schema(description = "UID")
    private String uid;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "年龄")
    private Integer age;

}
