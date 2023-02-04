package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 13:30
 * @LastEditTime: 2022-07-15 13:30
 */
@Slf4j
@Component
public class CommandLineStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
//      log.info("CommandLineStartupRunner傳入參數:{}", Arrays.toString(args));//傳遞方式以String Array方式傳遞
    }
}
