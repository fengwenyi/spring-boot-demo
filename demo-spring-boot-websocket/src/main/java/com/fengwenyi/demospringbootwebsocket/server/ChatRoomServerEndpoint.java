package com.fengwenyi.demospringbootwebsocket.server;

import com.fengwenyi.demospringbootwebsocket.domain.UserModel;
import com.fengwenyi.demospringbootwebsocket.service.IMsgService;
import com.fengwenyi.demospringbootwebsocket.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@ServerEndpoint("/chat-room")
@Slf4j
public class ChatRoomServerEndpoint {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMsgService msgService;

    @OnOpen
    public void open(Session session, @PathParam("username") String username) {
        UserModel userModel = new UserModel()
                .setId(session.getId())
                .setUsername(username)
                .setSession(session)
                ;
        userService.add(userModel);

        // 欢迎 xxx 用户加入聊天室
        String message = String.format("欢迎 %s 用户加入聊天室", username);
        msgService.sendBroadcast(message);
    }

    @OnMessage
    public void message(Session session, String message) {
        msgService.sendMsgAll(session.getId(), message);
    }

    @OnClose
    public void close(Session session) {
        // xxx 用户离开了聊天室
        UserModel userModel = userService.queryById(session.getId());
        String message = String.format("%s 用户离开了聊天室", userModel.getUsername());

        userService.deleteById(session.getId());

        msgService.sendBroadcast(message);
    }

    @OnError
    public void error(Session session, Throwable error) {
        log.error("发生错误, sessionId:" + session.getId());
        error.printStackTrace();
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
