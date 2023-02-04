package com.example.demo.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description:自定義異常的處理方法
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 13:32
 * @LastEditTime: 2022-07-18 13:32
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ModelViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest req, ModelViewException e){
        ModelAndView modelAndView = new ModelAndView();

        //將異常訊息設置如modelAndView
        modelAndView.addObject("exception",e);
        modelAndView.addObject("URL", req.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindException(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindException(BindException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(IllegalAccessException.class)
    @ResponseBody
    public AjaxResponse handleIllegalAccessException(IllegalArgumentException e){

        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                e.getMessage()));
    }

    @ExceptionHandler(CustomException.class)//這註解的意思是SpringBoot拋出Exception時且自訂義異常時就交給下方的方法來處理
    @ResponseBody //以AjaxResponse的形式響應到前端
    public AjaxResponse customerException(CustomException e){
        if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            //400異常不須要持久化,將異常訊息已有好的方式告知用戶就可以
            //TODO 將500異常訊息持久化處理,方便運維人員處理
        }
        return AjaxResponse.error(e); //傳入CustomException 自訂義異常code、message
    }

    //處理程序元在程序中未能捕獲(遺漏的)異常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e){
        //TODO 將異常訊息持久化處理,方便運維人員處理

        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }
}
