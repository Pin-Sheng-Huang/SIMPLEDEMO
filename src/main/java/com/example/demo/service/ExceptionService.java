package com.example.demo.service;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.CustomExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-18 13:11
 * @LastEditTime: 2022-07-18 13:11
 */

@Service
public class ExceptionService {

    //服務層,模擬系統異常
    public void systemBizError(){
        try{
            Class.forName("com.mysql.cj.jdbc.xxxx.Driver");//com.mysql.cj.jdbc.Driver
        } catch (ClassNotFoundException e) {
            throw new CustomException(
                    CustomExceptionType.SYSTEM_ERROR,
                    "在XXX業務,myBiz()方法內,出現ClassNotFoundExveption,請將該訊息告知管理員"
            );
        }
    }

    //服務層,模擬用戶輸入數據導致的校驗異常
    public void userBizError(int input){
//        if(input<0){
//            throw new CustomException(
//                    CustomExceptionType.USER_INPUT_ERROR,
//                    "您輸入的數據不符合業務邏輯,請確認後重新輸入"
//            );
//        }

        Assert.isTrue(input>=0,"您輸入的數據不符合業務邏輯,請確認後重新輸入");
        //....其他的業務
    }
}
