package com.fengwenyi.springboot.example.vo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-08-01
 */
@Data
@Accessors(chain = true)
public class StringNull2BlankResponseVo {

    private String name;

}
