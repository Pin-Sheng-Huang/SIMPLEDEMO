package com.example.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-07 20:11
 * @LastEditTime: 2022-07-07 20:11
 */
@Configuration
public class OpenAPIConfig {
   @Bean
    public GroupedOpenApi restApi(){
       return GroupedOpenApi.builder()
               .group("rest-api")//分組
               .pathsToMatch("/rest/**")//以rest開頭的openApi
               .build();
   }
   @Bean
    public GroupedOpenApi helloApi(){
       return GroupedOpenApi.builder()
               .group("hello")
               .pathsToMatch("/hello/**")
               .build();
   }
}
