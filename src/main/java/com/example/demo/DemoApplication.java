package com.example.demo;

import com.example.demo.config.event.MyListener1;
import com.example.demo.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication()//exclude= {DataSourceAutoConfiguration.class} //原本有加
@ImportResource(locations = {"classpath:beans.xml"}) //加載 beans.xml
@ServletComponentScan
public class DemoApplication {
    LombokPOJO.LombokPOJOBuilder lombokPOJO = LombokPOJO.builder().name("阿昇").age(27).address("newTaipeiCity").phone("0932");
    LombokPOJO lombokPOJO1 = LombokPOJO.builder().name("阿昇").age(27).address("newTaipeiCity").phone("0932").build();
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);  //原本
        //以下加上 ConfigurableApplicationContext,即為監聽器註冊
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        context.addApplicationListener(new MyListener1());
    }

}
