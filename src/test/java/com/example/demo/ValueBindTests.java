package com.example.demo;

import com.example.demo.model.Emploee;
import com.example.demo.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ValueBindTests {
   @Resource //把內容寫進來
    Family family;

   @Resource
    Emploee employee;
    @Test
    public void ValueBindTests() throws Exception {
        System.out.println(family.toString());

    }
    @Test
    public void ValueBindTests2() throws Exception {
        System.out.println(employee.toString());

    }
}
