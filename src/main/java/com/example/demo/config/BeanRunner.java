package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-15 14:52
 * @LastEditTime: 2022-07-15 14:52
 */
@Configuration
public class BeanRunner {
    @Bean//用來實例化CommandLineRunner
    @Order(1) //runner順序,但不保證applicationRunner
    public CommandLineRunner runner1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                //可在Edit Configuration中program Argument傳參數
 //               System.out.println("BeanCommandLineRunner run1()"+ Arrays.toString(args));
            }
        };
    }
    @Bean
    @Order(2)
    public CommandLineRunner runner2(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                //可在Edit Configuration中program Argument傳參數
 //               System.out.println("BeanCommandLineRunner run2()"+ Arrays.toString(args));
            }
        };
    }
    @Bean
    @Order(3)
    public ApplicationRunner runner3(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                //可在Edit Configuration中program Argument傳參數
   //             System.out.println("BeanApplicationRunner run3()"+ Arrays.toString(args.getSourceArgs()));
            }
        };
    }
}
