package com.fengwenyi.demospringbootwebsocket.enums;

import lombok.Getter;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@Getter
public enum MsgTypeEnum {

    CONN(0x00, "连接")
    , BROADCAST(0x01, "广播")
    , CHAT(0x02, "聊天")

    ;

    private final Integer code;

    private final String desc;

    MsgTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
