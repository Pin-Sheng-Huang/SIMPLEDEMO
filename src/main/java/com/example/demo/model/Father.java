package com.example.demo.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-08 15:25
 * @LastEditTime: 2022-07-08 15:25
 */
@Data
public class Father {
    private String  name;

    @Min(20) //設定最小值為20
    private Integer age;

}
