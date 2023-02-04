package com.example.demo.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: demo
 * @description:http狀態與回傳的code數字一致
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 14:26
 * @LastEditTime: 2022-07-18 14:26
 */
@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {//這接口的作用是在數據返回前端(AjaxResponse)之前做最後一步攔截處理
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {//support的含意 是支持那些響應類
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,//響應結果的類型 EX:Json、xml
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //如果響應結果為Json數據類型
        if(mediaType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)){
            if(body instanceof AjaxResponse){
                serverHttpResponse.setStatusCode(HttpStatus.valueOf(((AjaxResponse)body).getCode()));
                return body;
            }else{
                serverHttpResponse.setStatusCode(HttpStatus.OK);
               return AjaxResponse.success(body);
            }

        }

        return body;
    }
}
