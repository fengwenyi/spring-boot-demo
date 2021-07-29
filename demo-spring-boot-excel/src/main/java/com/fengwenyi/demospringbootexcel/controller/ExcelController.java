package com.fengwenyi.demospringbootexcel.controller;

import com.fengwenyi.demospringbootexcel.util.ExcelUtils;
import com.fengwenyi.demospringbootexcel.vo.BusClick;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-05-21
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @PostMapping("/export3")
    public void export3(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<BusClick> resultList = new ArrayList<BusClick>();
        BusClick busClick = new BusClick();
        busClick.setCityCode("a1");
        busClick.setClientVer("a2");
        busClick.setDate("a3");
        busClick.setMarkId("a4");
        busClick.setToaluv("a5");
        resultList.add(busClick);

        busClick = new BusClick();
        busClick.setCityCode("b1");
        busClick.setClientVer("b2");
        busClick.setDate("b3");
        busClick.setMarkId("b4");
        busClick.setToaluv("b5");
        resultList.add(busClick);

        long t1 = System.currentTimeMillis();
        ExcelUtils.writeExcel(response, resultList, BusClick.class);
        long t2 = System.currentTimeMillis();
        System.out.printf("write over! cost: %sms%n", (t2 - t1));
    }

}
