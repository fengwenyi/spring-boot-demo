package com.fengwenyi.springboot.mybatis.model;

import lombok.Data;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-15
 */
@Data
public class PageModel {

    private Long current;
    private Integer pageSize;

}
