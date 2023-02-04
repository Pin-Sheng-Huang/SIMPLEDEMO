package com.example.demo.exception;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 20:50
 * @LastEditTime: 2022-07-15 20:50
 */

public class CustomException extends RuntimeException{//自訂義異常要繼承RuntimeException
    //異常錯誤編碼
    private int code;
    //異常訊息
    private String message;

    public CustomException(){    }//所以異常創建都是物化下來之後的枚舉來創建的,之所以使用private是不希望程序員亂創建Exception

    //下方兩個構造函數,透過自己創建的枚舉且利用自訂義描述來體現異常
    public CustomException(CustomExceptionType exceptionTypeEnum) {

        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getDesc();
    }
    public CustomException(CustomExceptionType exceptionTypeEnum,String message) {

        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }




    public int getCode(){ return  code;}

    @Override
    public String getMessage(){ return  message;}
}
