package com.fengwenyi.demospringbootwebsocket.service;

/**
 * @author Wenyi Feng
 */
public interface IMsgService {

    // 向指定用户发送消息
    boolean sendMsg(String clientId, String message);

    // 群发
    boolean sendMsgAll(String message);
}
