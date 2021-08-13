package com.fengwenyi.demospringbootwebsocket.server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Wenyi Feng
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketServer extends BaseMsg implements IMsgService {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //在线用户列表
    private static final ConcurrentMap<String, Session> sessions;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    static {
        sessions = new ConcurrentHashMap<>();
    }

    @Override
    public boolean sendMsgToUser(String clientId, String message) {
        boolean result = false;
        Session session = sessions.get(clientId);
        try {
            Result rsObj = new Result();
            rsObj.setLabel(Label.BROADCAST);
            rsObj.setData(message);
            sendMsg(session, new Gson().toJson(rsObj));
            result = true;
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean sendMsgToAllUser(String message) {
        boolean result = false;
        for (ConcurrentMap.Entry<String, Session> entry : sessions.entrySet()) {
            Session session = entry.getValue();
            try {
                Result rsObj = new Result();
                rsObj.setLabel(Label.BROADCAST);
                rsObj.setData(message);
                sendMsg(session, new Gson().toJson(rsObj));
                result = true;
            } catch (IOException e) {
                result = false;
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        String sessionId = session.getId();

        sessions.put(sessionId, session);
        addOnlineCount();           //在线数加1
        log.info("有新连接加入, Session Id=" + sessionId + "！当前在线人数为" + getOnlineCount());
        try {
            Result result = new Result();
            result.setLabel(Label.CONN);
            result.setData("连接成功，欢迎你：" + sessionId);
            sendMsg(session, new Gson().toJson(result));
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String sessionId = session.getId();
        log.info("sessionId:" + sessionId);
        sessions.remove(sessionId);
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端("+session.getId()+")的消息:" + message);
        // xx 给 xx 发消息
        // {"to":"sId","content":"content"}
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String to = jsonObject.get("to").getAsString();
        String content = jsonObject.get("content").getAsString();
        Session toSession = sessions.get(to);
        try {
            Result result = new Result();
            result.setLabel(Label.CHAT);

            Map<String, String> news = new HashMap<>();
            news.put("from", session.getId());
            news.put("content", content);

            result.setData(news);
            sendMsg(toSession, new Gson().toJson(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误, sessionId:" + session.getId());
        error.printStackTrace();
    }


    public static synchronized int getOnlineCount() {
        Integer sessionsKeyNum = sessions.keySet().size();
        if (onlineCount == sessionsKeyNum) return onlineCount;
        onlineCount = sessionsKeyNum;
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
