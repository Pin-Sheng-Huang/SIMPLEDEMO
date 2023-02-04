package com.example.demo.exception;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 16:58
 * @LastEditTime: 2022-07-18 16:58
 */

public class ModelViewException extends RuntimeException{

    //將Exception 轉換為ModelViewException
    public static ModelViewException transfer(Throwable cause){
        return new ModelViewException(cause);//創構造函數
    }

    private ModelViewException(Throwable cause) {//且傳入throwable異常,調用ModelViewException的父類RuntimeException
        super(cause);
    }
}
