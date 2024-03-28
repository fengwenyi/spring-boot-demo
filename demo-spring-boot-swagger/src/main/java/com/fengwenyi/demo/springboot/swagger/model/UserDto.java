package com.fengwenyi.demo.springboot.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-03-25
 */
@Schema(description = "用户 dto")
@Data
public class UserDto {

    @Schema(description = "用户ID")
    private String userId;

}
