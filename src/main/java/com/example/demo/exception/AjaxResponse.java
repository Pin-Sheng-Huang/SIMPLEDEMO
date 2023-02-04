package com.example.demo.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-04 17:23
 * @LastEditTime: 2022-07-04 17:23
 */
@Data
//@ApiModel(value="通用響應數據結構類")//swagger2註解
@Schema(title="通用響應數據結構類")//OpenApi
public class AjaxResponse {
    //@ApiModelProperty(value="請求是否處理成功")//swagger2註解
    @Schema(title="通用響應數據結構類")
    private boolean success;
    //@ApiModelProperty(value="請求是否處理成功",example ="200、400、500")//swagger2註解
    @Schema(title="通用響應數據結構類")
    private int code; //請求響應狀態馬200 400 500
    //@ApiModelProperty(value="請求結果描述信息")//swagger2註解
    @Schema(title="通用響應數據結構類")
    private String message;
    //@ApiModelProperty(value="請求結果數據")//swagger2註解
    @Schema(title="通用響應數據結構類")
    private Object data;

    private AjaxResponse(){    }//構造函數

    //請求出現異常時的響應數據封裝
    public  static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setSuccess(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }
    //請求出現異常時的響應數據封裝
    public static AjaxResponse error(CustomExceptionType customExceptionType,
                                     String errorMessage){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setSuccess(false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);

        return resultBean;
    }
    public static  AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("請求響應成功!");


        return ajaxResponse;
    }


    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查詢完成");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj,String message) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
//    public static AjaxResponse noSuccess(Object obj) {
//        AjaxResponse ajaxResponse = new AjaxResponse();
//        ajaxResponse.setSuccess(true);
//        ajaxResponse.setCode(500);
//        ajaxResponse.setMessage("伺服器錯誤");
//        return ajaxResponse;
//    }
}
