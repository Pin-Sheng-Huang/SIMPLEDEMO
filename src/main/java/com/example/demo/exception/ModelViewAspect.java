package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:AOP範例
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 16:46
 * @LastEditTime: 2022-07-18 16:46
 */

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    //設置切入點: 這裡直接攔截被@ModelView 註解的方法
    @Pointcut("@annotation(com.example.demo.exception.ModelView)")
    public void pointcut(){}
    /**
     * 當有ModelView 的註解方法拋出異常的時候,作如下的處理
     */
    @AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void afterThrowable(Throwable e){ throw ModelViewException.transfer(e);}//攔截了所有的異常,前提是方法上標註了@ModelView
}
