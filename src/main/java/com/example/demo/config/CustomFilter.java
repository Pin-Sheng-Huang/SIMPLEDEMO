package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-14 16:30
 * @LastEditTime: 2022-07-14 16:30
 */
@Slf4j
//@WebFilter(filterName = "customFilter",urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig)throws ServletException{//初始化函數
        log.info("filter 初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {//實現業務處理的核心函數
        log.info("customFilter 請求處理之前----doFilter方法之前過濾請求");
        servletRequest.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest , servletResponse);

        servletResponse.setCharacterEncoding("UTF-8");
        log.info("customFilter 請求處理之後----doFilter方法之後處理響應");
    }

    @Override
    public void destroy(){
    log.info("filter 銷毀");
    }
}
