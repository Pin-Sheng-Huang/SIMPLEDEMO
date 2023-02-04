package com.example.demo.model;

import lombok.Data;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-08 15:29
 * @LastEditTime: 2022-07-08 15:29
 */
@Data
public class Child {
    private String  name;
    private Integer age;
    private Friend[]  friends;
}
