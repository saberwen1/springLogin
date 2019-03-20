package com.fate.login.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: fate
 * @Date: 2019/3/15 14:24
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/user")
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long time = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println(requestURI + "过滤器耗时：" + (new Date().getTime() - time));
    }

    @Override
    public void destroy() {
        System.out.println("filter destory...");
    }
}
