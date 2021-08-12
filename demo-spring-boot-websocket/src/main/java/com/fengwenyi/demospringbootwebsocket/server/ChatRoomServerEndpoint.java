package com.fengwenyi.demospringbootwebsocket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@ServerEndpoint("/chat-room")
public class ChatRoomServerEndpoint {

    @OnOpen
    public void open() {

    }

    @OnMessage
    public void message() {

    }

    @OnClose
    public void close() {

    }

    @OnError
    public void error() {

    }

}
