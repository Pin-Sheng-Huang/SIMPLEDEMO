package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-14 15:32
 * @LastEditTime: 2022-07-14 15:32
 */
@Slf4j
@WebListener//把listener實例化注入spring上下文
public class CustomListener implements ServletContextListener, ServletRequestListener, HttpSessionListener,
        ServletRequestAttributeListener {

    @Override
    public  void contextInitialized(ServletContextEvent se){
        log.info("=================context創建");
    }
    @Override
    public  void contextDestroyed(ServletContextEvent se){
        log.info("=================context銷毀");
    }
    @Override
    public  void requestDestroyed(ServletRequestEvent sre){
        log.info("+++++++++++++++++++request監聽器: 銷毀");
    }
    @Override
    public  void requestInitialized(ServletRequestEvent se){
        log.info("+++++++++++++++++++request監聽器: 創建");
    }
    @Override
    public  void sessionCreated(HttpSessionEvent se){
        log.info("----------------------Session: 創建");
    }
    @Override
    public  void sessionDestroyed(HttpSessionEvent se){
        log.info("----------------------Session: 銷毀");
    }
    @Override
    public  void attributeAdded(ServletRequestAttributeEvent srae){
        log.info("----------------------attributeAdded");
    }
    @Override
    public   void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("----------------------attributeRemoved");
    }
    @Override
    public  void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("----------------------attributeRemoved");
    }
}
