package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 18:52
 * @LastEditTime: 2022-07-15 18:52
 */
@Data
public class Student2Dto implements Serializable {
    private String name;
    private Long tel;
}
