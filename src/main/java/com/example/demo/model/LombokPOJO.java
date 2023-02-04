package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-01 20:00
 * @LastEditTime: 2022-07-01 20:00
 */
@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LombokPOJO {
    //@Slf4j 生成=> private static  final Logger log  = LoggerFactory.getLogger(LombokPOJO.class);
    private String name;
    private String address;
    private Integer age;
    private String phone;
}
