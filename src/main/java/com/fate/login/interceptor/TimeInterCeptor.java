package com.fate.login.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author: fate
 * @Date: 2019/3/15 17:11
 * @Version 1.0
 */
@Component
public class TimeInterCeptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       /* System.out.println("interceptor preHandle 開始執行");
        request.setAttribute("time",new Date().getTime());*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String requestURI = request.getRequestURI();
//        System.out.println(requestURI+"postHandle执行时长："+(System.currentTimeMillis()-(long)request.getAttribute("time")));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("interceptor afterCompletion 執行結束");
    }
}
