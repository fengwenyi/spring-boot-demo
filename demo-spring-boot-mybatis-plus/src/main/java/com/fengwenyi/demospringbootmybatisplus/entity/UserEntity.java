package com.fengwenyi.demospringbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fengwenyi.apistarter.entity.BaseBizEntity;
import com.fengwenyi.demospringbootmybatisplus.entity.bo.WalletBo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-23
 */
@Getter
@Setter
@TableName(value = "t_user", autoResultMap = true)
public class UserEntity extends BaseBizEntity {

    private String username;

    private String password;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private WalletBo wallet;

}
