package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-08 19:29
 * @LastEditTime: 2022-07-08 19:29
 */
@Data
@Configuration
@PropertySource(value="classpath:employee.properties",encoding = "utf-8")
public class Emploee {
    @Value("#{'${employee.names}'.split('\\|')}")//SpEL表達法
    private List<String> emploeeNames;

    @Value("#{'${employee.names}'.split('\\|')[0]}")//SpEL表達法
    private List<String> firstemploeeNames;

    @Value("#{${employee.age}}")//SpEL表達法
    private Map<String, Integer> emploeeAges;

    @Value("#{${employee.age}.two}")//SpEL表達法 獲取two屬性值
    //@Value("#{${employee.age}['two']}")
    private String emploeeAgeTwo;

    @Value("#{${employee.age}['five']?:31}") //先去age 中讀取five 如果沒有就給31

    private Integer ageWithoutValue;

    @Value("#{systemProperties['java.home']}") //讀取環境變數
    private String javaHome;

    @Value("#{systemProperties['user.dir']}") //讀取用戶的主目錄
    private String userDir;
}
