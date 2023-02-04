package com.example.demo.model;

import com.example.demo.service.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-08 15:03
 * @LastEditTime: 2022-07-08 15:03
 */

@Data
@Component
@Validated //成員變數校正生效
@ConfigurationProperties(prefix = "family")//一次性注入 到對像中
@PropertySource(value = "classpath:family.yml", factory = MixPropertySourceFactory.class)
public class Family {

    //@Value("${family.family-name}")//把yml 中的family.family-name 賦予值在 private String familyName;
    //@NotEmpty//如familyName 是空值的話 會校驗失敗,測試失敗
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
