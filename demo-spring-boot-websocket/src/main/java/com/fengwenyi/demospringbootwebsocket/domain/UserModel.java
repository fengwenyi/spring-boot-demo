package com.fengwenyi.demospringbootwebsocket.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.websocket.Session;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@Data
@Accessors(chain = true)
public class UserModel {

    private String id;

    private String username;

    private Session session;

}
