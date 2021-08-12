package com.fengwenyi.demospringbootwebsocket.service.impl;

import com.fengwenyi.demospringbootwebsocket.service.BaseMsg;
import com.fengwenyi.demospringbootwebsocket.service.IMsgService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@Service
public class MsgServiceImpl extends BaseMsg implements IMsgService {
    @Override
    public boolean sendMsg(String clientId, String message) {
        return false;
    }

    @Override
    public boolean sendMsgAll(String message) {
        return false;
    }
}
