package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 13:32
 * @LastEditTime: 2022-07-15 13:32
 */
@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        log.info("ApplicationRunner參數名稱: {}", args.getOptionNames());
//        log.info("ApplicationRunner參數值: {}", args.getOptionValues("age"));
//        log.info("ApplicationRunner參數: {}", Arrays.toString(args.getSourceArgs()));
    }
}
