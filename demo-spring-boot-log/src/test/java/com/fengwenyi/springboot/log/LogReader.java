package com.fengwenyi.springboot.log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-29
 */
public class LogReader implements Runnable {
    private File logFile = null;
    private long lastTimeFileSize = 0; // 上次文件大小
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    public LogReader(File logFile) {
        this.logFile = logFile;
        //lastTimeFileSize = logFile.length();
    }

    /**
     * 实时输出日志信息
     */
    public void run() {
        while (true) {
            try {
                RandomAccessFile randomFile = new RandomAccessFile(logFile, "r");
                randomFile.seek(lastTimeFileSize);
                String tmp = null;
                while ((tmp = randomFile.readLine()) != null) {
//                    System.out.println(dateFormat.format(new Date()) + "\t"
//                            + tmp);
                    System.out.println(tmp);
                }
                lastTimeFileSize = randomFile.length();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
