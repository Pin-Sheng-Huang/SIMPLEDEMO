package com.example.demo.exception;

public enum CustomExceptionType {
    USER_INPUT_ERROR(400,"您輸入的數據錯誤或您沒有權限訪問資源"),
    SYSTEM_ERROR(500,"系統出現異常,請您稍後在試或連繫管理員!"),
    OTHER_ERROR(999,"系統出現未知異常,請聯繫管理員!");
    private String desc;//異常類型中文描述

    private int code;//code

    CustomExceptionType(int code,String desc ) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
