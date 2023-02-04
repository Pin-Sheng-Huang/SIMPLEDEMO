package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-14 20:37
 * @LastEditTime: 2022-07-14 20:37
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource //為了添加攔截器把已寫的攔截器注入這個配置類
    CustomHandlerInterceptor customHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){//用來添加攔截器的
        //註冊攔截器 攔截規則
        //多個攔截器時 以此添加 執行順序案添加順序
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");//註冊到Spring容器中 ,路徑為所有的請求(addPathPatterns("/*")
    }
}
