package com.fengwenyi.springbootdemo.demopdf;

import com.fengwenyi.springbootdemo.demopdf.util.PdfUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-29
 */
@RestController
@SpringBootApplication
public class DemoPdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPdfApplication.class, args);
    }

    // 有误
    @RequestMapping("/")
    public String demo() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("sex", "男");
        data.put("payType", "微信");
        data.put("receiptCode", "20010001");
        data.put("realName", "nnn");
        data.put("age", "30");
        data.put("examType", "统考");
        data.put("college", "科技大学");
        data.put("major", "计算机");

        data.put("email", "lynhchun@126.com");
        data.put("qqWx", "616690485");
        data.put("parentPhone", "13453457219");
        data.put("phone", "15392687219");

        data.put("targetMajor", "计算机科学与技术");
        data.put("examDate", "2019");
        data.put("tutorType", "暑假冲刺班");
        data.put("courseName", "英语、数学");

        data.put("createTime", "2019-04-18 16:26:30");
        data.put("payAmountWord", "二百元整");
        data.put("payAmount", "200");
        data.put("createBy", "nnn");
        data.put("chargePerson", "nnn");
        data.put("remark", "无");
        data.put("financeUser", "nnn");

        data.put("payStatus", "（全额）");


        // 没有模板
        String path = "/Users/wenyifeng/Downloads/" + UUID.randomUUID().toString() + ".pdf";

        PdfUtils.generatePDF(path, data);

        return "SUCCESS";
    }

}
