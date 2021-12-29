package com.fengwenyi.demospringbootapiresult.controller;

import com.fengwenyi.api.result.PageResponseVo;
import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/demo")
    public ResponseTemplate<Void> demo() {
        return ResponseTemplate.success();
    }

    @RequestMapping("/err-msg")
    public ResponseTemplate<Void> errMsg() {
        return ResponseTemplate.fail("test error!");
    }

    @RequestMapping("/page-response")
    public ResponseTemplate<PageResponseVo<List<String>>> pageResponse() {
//        PageResponseVo<List<String>> pageResponseVo = PageResponseVo.Builder.newBuilder() // 暂时不能用
        PageResponseVo<List<String>> pageResponseVo = new PageResponseVo.Builder<List<String>>()
                .currentPage(1)
                .pageSize(10)
                .totalPages(100)
                .totalRows(1000)
                .content(Arrays.asList("u1", "u2", "u3"))
                .build();

        PageResponseVo<List<String>> pageResponseVo2 = new PageResponseVo<List<String>>()
                .setCurrentPage(1)
                .setPageSize(10)
                .setTotalPages(10)
                .setTotalRows(1000)
                .setContent(Arrays.asList("uU1", "uU2", "uU3"))
                ;


        return ResponseTemplate.success(pageResponseVo);
    }
}
