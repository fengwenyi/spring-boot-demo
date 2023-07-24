package com.fengwenyi.demospringbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fengwenyi.demospringbootmybatisplus.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2023-07-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_log")
public class LogEntity extends BaseEntity {

    private String logKey;

    private String bizId;

    private String msg;

    private String data;

    private String error;

}
