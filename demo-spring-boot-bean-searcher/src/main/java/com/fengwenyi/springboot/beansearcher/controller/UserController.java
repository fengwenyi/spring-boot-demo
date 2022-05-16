package com.fengwenyi.springboot.beansearcher.controller;

import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.fengwenyi.springboot.beansearcher.bo.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-05-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MapSearcher mapSearcher;  // 注入检索器（由 bean-searcher-boot-starter 提供）

    @GetMapping("/search")
    public SearchResult<Map<String, Object>> search(HttpServletRequest request) {
        // 这里咱们只写一行代码
        return mapSearcher.search(UserBo.class, MapUtils.flat(request.getParameterMap()));
    }

}
