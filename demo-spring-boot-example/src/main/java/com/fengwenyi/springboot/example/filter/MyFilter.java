package com.fengwenyi.springboot.example.filter;

import com.fengwenyi.javalib.net.RequestUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-09-14
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info(RequestUtils.getPostData((HttpServletRequest) servletRequest));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
