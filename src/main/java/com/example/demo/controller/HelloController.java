package com.example.demo.controller;

import com.example.demo.config.event.MyEvent;
import com.example.demo.model.LombokPOJO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-01 17:24
 * @LastEditTime: 2022-07-01 17:24
 */
@RestController
public class HelloController {
    @Resource //需要誰就注入進來
    private ApplicationContext applicationContext;
    @RequestMapping("/hello") //對外服務的路徑
    public String hello(String name){
        LombokPOJO lombokPOJO  = new LombokPOJO();
        return "heyController2:" + name;

    }
    @RequestMapping("/hello2")
    public String hello(HttpServletRequest request, HttpSession session){

        //TEST
//        //操作attribute
//        request.setAttribute("a","a");
//        request.setAttribute("a","b");
//        request.getAttribute("a");
//        request.removeAttribute("a");
//        //操作session
//        session.setAttribute("a","b");
//        session.getAttribute("a");
//        session.invalidate();
        applicationContext.publishEvent(new MyEvent("測試事件")); //通過這行API把事件發布
        return "hello World~~";
    }
}
