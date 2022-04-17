package com.fengwenyi.demospringbootmybatisplus.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-03-07
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 6174660062297043416L;

    /**
     * ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDateTime;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建者名字
     */
    private String createUserName;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateDateTime;

    /**
     * 更新者ID
     */
    private Long updateUserId;

    /**
     * 更新者名字
     */
    private String updateUserName;

}
