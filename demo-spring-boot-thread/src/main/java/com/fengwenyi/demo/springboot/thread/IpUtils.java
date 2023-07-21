package com.fengwenyi.demo.springboot.thread;

import info.hxgy.business.appointment.core.common.constants.LogKey;
import info.hxgy.business.appointment.core.log.ILog;
import info.hxgy.business.appointment.core.log.LogFactory;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-11
 */
@Slf4j
public class IpUtils {


    public static String getLocalIp() {
        String ip = "127.0.0.1";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("get local ip exception: {}", e.getLocalizedMessage(), e);
        }
        return ip;
    }

}
