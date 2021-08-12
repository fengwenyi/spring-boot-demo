package com.fengwenyi.demospringbootwebsocket.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demospringbootwebsocket.domain.UserModel;
import com.fengwenyi.demospringbootwebsocket.enums.MsgTypeEnum;
import com.fengwenyi.demospringbootwebsocket.service.BaseMsg;
import com.fengwenyi.demospringbootwebsocket.service.IMsgService;
import com.fengwenyi.demospringbootwebsocket.service.IUserService;
import com.fengwenyi.demospringbootwebsocket.vo.ResponseVo;
import com.fengwenyi.javalib.convert.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-12
 */
@Service
public class MsgServiceImpl extends BaseMsg implements IMsgService {

    @Autowired
    private IUserService userService;

    @Override
    public boolean sendMsg(String id, String message) {

        UserModel userModel = userService.queryById(id);

        ResultTemplate<ResponseVo> result = ResultTemplate.success(
                new ResponseVo()
                        .setMsgType(MsgTypeEnum.CHAT.getCode())
                        .setMessage(message));

        try {
            sendMsg(userModel.getSession(), JsonUtils.convertString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean sendMsgAll(String senderId, String message) {

        List<UserModel> userModelList = userService.queryAll();
        UserModel sendUserModel = userService.queryById(senderId);

        ResultTemplate<ResponseVo> result = ResultTemplate.success(
                new ResponseVo()
                        .setMsgType(MsgTypeEnum.CHAT.getCode())
                        .setUsername(sendUserModel.getUsername())
                        .setMessage(message));

        for (UserModel userModel : userModelList) {
            try {
                sendMsg(userModel.getSession(), JsonUtils.convertString(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public void sendBroadcast(String message) {
        List<UserModel> userModelList = userService.queryAll();

        ResultTemplate<ResponseVo> result = ResultTemplate.success(
                new ResponseVo()
                        .setMsgType(MsgTypeEnum.BROADCAST.getCode())
                        .setMessage(message));

        for (UserModel userModel : userModelList) {
            try {
                sendMsg(userModel.getSession(), JsonUtils.convertString(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
