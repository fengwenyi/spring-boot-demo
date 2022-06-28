package com.fengwenyi.springboot.kafka.sdk;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
@Data
@Accessors(chain = true)
public class MessageModel<T> implements Serializable {

    private static final long serialVersionUID = -8264073913349578584L;

    private String id;

    private T data;

    private LocalDateTime sendTime;
}
