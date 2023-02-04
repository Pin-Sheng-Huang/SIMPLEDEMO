package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-07 16:11
 * @LastEditTime: 2022-07-07 16:11
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//固定端口 PORT:8888
public class ImportResourceTests {
   @Resource //把內容寫進來
    private ConfigurableApplicationContext ioc;//管理配置上下文

    @Test
    public void testImport() throws Exception {
        boolean isImport =  ioc.containsBean("testBeanService");//Bean已注入springboot上下文的容器環境中
        System.out.println(isImport);
    }

}
