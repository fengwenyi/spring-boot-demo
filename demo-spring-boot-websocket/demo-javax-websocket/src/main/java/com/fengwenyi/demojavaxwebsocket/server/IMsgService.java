package com.fengwenyi.demojavaxwebsocket.server;

/**
 * @author Wenyi Feng
 */
public interface IMsgService {

    // 向指定用户发送消息
    boolean sendMsgToUser(String clientId, String message);

    // 群发
    boolean sendMsgToAllUser(String message);
}
