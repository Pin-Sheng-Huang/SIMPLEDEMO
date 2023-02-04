package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-06 20:30
 * @LastEditTime: 2022-07-06 20:30
 */
@Configuration //當前為配置類
@EnableSwagger2 //啟用SWAGGER API文黨
public class SwaggerConfig {
    @Bean //初始化
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//API資訊 抓下方apiInfo的方法
                .select()
                //掃描basePackage包下面的"/rest/"路徑下的內容做為街口文檔構件的目標
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))//掃描這個目錄demo底下的controller
                .paths(PathSelectors.regex("/rest/.*"))//路徑下形成文檔
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DEMO項目API")
                .description("EASY的restful風格,JAVA王者")
                .termsOfServiceUrl("https://swagger.io/") //當前文檔的協議
                .version("1.0")
                .build();
    }
}
