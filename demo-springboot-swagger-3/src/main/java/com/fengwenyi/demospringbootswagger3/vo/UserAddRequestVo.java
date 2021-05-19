package com.fengwenyi.demospringbootswagger3.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-18
 */
@Schema
@Data
public class UserAddRequestVo {

    @Schema(name = "UID")
    private String uid;

    @Schema(name = "姓名")
    private String name;

    @Schema(name = "年龄")
    private Integer age;

}
