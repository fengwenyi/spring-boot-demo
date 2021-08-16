package com.fengwenyi.demospringwebsocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-16
 */
@Component
public class MyInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("握手开始");
        // 获得请求参数
        HashMap<String, String> paramMap = GetApiParamMap(request.getURI().getQuery());
        String uid = paramMap.get("token");
        if (StringUtils.hasText(uid)) {
            // 放入属性域
            attributes.put("token", uid);
            System.out.println("用户 token " + uid + " 握手成功！");
            return true;
        }
        System.out.println("用户登录已失效");
        return false;
    }

    /**
     * 握手后
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param exception
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        System.out.println("握手完成");
    }

    /**
     * 根据api参数字符串获取api参数映射
     * @param url
     * @return
     */
    public static HashMap<String, String> GetApiParamMap(String url){
        HashMap<String, String> paramsMap = new HashMap<String, String>();
        if(!StringUtils.isEmpty(url)){
            String[] keyVlauePairAry = url.split("&");
            for (String keyVlauePair : keyVlauePairAry) {
                if (StringUtils.hasText(keyVlauePair)) {
                    int equalIndex = keyVlauePair.indexOf('=');
                    if(equalIndex==-1 || equalIndex>=keyVlauePair.length()-1) continue;
                    String titleString = keyVlauePair.substring(0, equalIndex);
                    String titleValueString = keyVlauePair.substring(equalIndex+1,keyVlauePair.length());
                    paramsMap.put(titleString,titleValueString);
                }
            }
        }
        return paramsMap;
    }
}
