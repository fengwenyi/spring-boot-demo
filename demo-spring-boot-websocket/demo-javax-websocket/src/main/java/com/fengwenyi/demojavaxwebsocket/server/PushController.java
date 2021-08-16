package com.fengwenyi.demojavaxwebsocket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wenyi Feng
 */
@RestController
@RequestMapping("/push")
public class PushController {

    @Autowired
    private IMsgService msgService;

    @GetMapping("/all")
    public String sendMsgAllUser () {
        boolean rs = msgService.sendMsgToAllUser("Hello everyone");
        if (rs) return "success";
        return "error";
    }

    @GetMapping("/user/{clientId}")
    public String sendMsgUser (@PathVariable("clientId") String clientId) {
        boolean rs = msgService.sendMsgToUser(clientId, "Hey " + clientId);
        if (rs) return "success";
        return "error";
    }

}
