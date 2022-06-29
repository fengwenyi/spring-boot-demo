package com.fengwenyi.springboot.log;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
public class LogFileTest {

    @Test
    public void testRead() throws Exception {
        //日志文件路径，获取最新的
        // String filePath = System.getProperty("user.home") + "/log/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/"+applicationName+".log";
//        String filePath = System.getProperty("user.home") + "/log/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/"+applicationName+".log";

        //字符流
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        Object[] lines = reader.lines().toArray();

//        for ()

        String filePath = "/Users/wenyifeng/Projects/IdeaProjects/DemoProjects/spring-boot-demo/logs/demo-spring-boot-log-2022-06-29.log";

        Thread logThread = new Thread(new LogReader(new File(filePath)));
        logThread.start();
    }

    public static void main(String[] args) throws Exception {
       new LogFileTest().testRead();
    }

}
