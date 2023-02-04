package com.example.demo.service;

import com.example.demo.exception.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-05 17:15
 * @LastEditTime: 2022-07-05 17:15
 */
//下載EXCEL

@Service
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    @Autowired
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/json"); //響應給前端是EXCEL的數據格式 ,原本application/vnd.ms-excel
    public ResponseToXlsConverter() {
        super(EXCEL_TYPE);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return (AjaxResponse.class == clazz);
    }
    //序列化
    @Override //readInternal針對requestbody數據處理
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }
    //反序列化
    @Override //writeInternal 針對responsebody數據處理
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //EXCEL
//        final Workbook workbook = new HSSFWorkbook();
//        final Sheet sheet = workbook.createSheet();
//        final Row row = sheet.createRow(0);
//        row.createCell(0).setCellValue(ajaxResponse.getMessage());//放入ajax的訊息
//        row.createCell(1).setCellValue(ajaxResponse.getData().toString());//放入ajax的資料
//        workbook.write(outputMessage.getBody());//通過EXCEL把數據響應給後端
//        System.out.println(ajaxResponse);
//        System.out.println(outputMessage);

//----------------------------------------------------
//        mappingJackson2HttpMessageConverter.write(ajaxResponse,new MediaType("application","*+json"),outputMessage);
//        MappingJackson2HttpMessageConverter t = mappingJackson2HttpMessageConverter;//.write(ajaxResponse,new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET),outputMessage);
//        System.out.println(t.write(ajaxResponse.getClass(), new MediaType("application","*+json")););
        mappingJackson2HttpMessageConverter.write(ajaxResponse, ajaxResponse.getClass(), new MediaType("application","*+json"), outputMessage);
    }
}
