package com.fengwenyi.demospringbootcsv.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-19
 */
public class CsvUtils {

    private static final String SUFFIX = ".csv";

    //行尾分隔符定义
    private final static String NEW_LINE_SEPARATOR = "\n";

    //上传文件的存储位置
    private final static URL PATH = Thread.currentThread().getContextClassLoader().getResource("");

    /**
     * 生成CSV文件
     * @param fileName 文件名
     * @param heads 头部
     * @param values 值
     * @return 文件
     * @throws IOException IO异常
     */
    public static File genCsvFile(String fileName, List<String> heads, List<List<Object>> values) throws IOException {
        String filePath = "./";
        if (PATH != null) {
            filePath = PATH.getPath();
        }
        // 创建文件
        File file = File.createTempFile(fileName, SUFFIX, new File(filePath));

        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file), StandardCharsets.UTF_8));

        CSVPrinter printer = new CSVPrinter(bufferedWriter, format);

        // 写入表头
        printer.printRecord(heads);

        // 写入内容
        for (List<Object> value : values) {
            printer.printRecord(value);
        }

        printer.close();
        bufferedWriter.close();

        return file;
    }

    /**
     * 文件下载
     * @param response 响应
     * @param file 文件
     * @return 是否下载成功
     */
    public static boolean downloadFile(HttpServletResponse response, File file) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream os = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            os = response.getOutputStream();
            //MS产本头部需要插入BOM
            //如果不写入这几个字节，会导致用Excel打开时，中文显示乱码
            os.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
            byte[] buffer = new byte[1024];
            int i = bufferedInputStream.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bufferedInputStream.read(buffer);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            boolean delete = file.delete();
            if (!delete) {
                System.err.println("文件删除失败，文件路径=" + file.getAbsolutePath());
            }
        }
        return false;
    }

}
