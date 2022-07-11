package com.fengwenyi.springboot.log;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.management.resources.agent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-20
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @RequestMapping("/browser")
    public String getBrowser(HttpServletRequest request) {

        String ua = request.getHeader("User-Agent");

        // Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.5 Safari/605.1.15
        // Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36

        log.info("ua: [{}]", ua);

        log.info("========================");

        UserAgent userAgent = UserAgent.parseUserAgentString(ua);

        // 浏览器
        Browser browser = userAgent.getBrowser();
        log.info("类型：" + browser.getBrowserType() + "\n名称：" + browser.getName() + "\n厂商："
                + browser.getManufacturer() + "\n产品系列：" + browser.getGroup() + "\n引擎：" + browser.getRenderingEngine());

        log.info("browser info: ");
        log.info("类型：[{}]", browser.getBrowserType());
        log.info("名称：[{}]", browser.getName());
        log.info("厂商：[{}]", browser.getManufacturer());
        log.info("产品系列：[{}]", browser.getGroup());
        log.info("引擎：[{}]", browser.getRenderingEngine());

        // 浏览器版本
        Version version = userAgent.getBrowserVersion();
        log.info("========================");
        log.info("主版本：" + version.getMajorVersion() + "\n小版本：" + version.getMinorVersion() + "\n完整版本："
                + version.getVersion());
        // 操作系统
        log.info("========================");
        OperatingSystem os = userAgent.getOperatingSystem();
        log.info("名称：" + os.getName() + "\n设备类型：" + os.getDeviceType() + "\n产品系列：" + os.getGroup() + "\n生成厂商："
                + os.getManufacturer());
        return "success";
    }

}
