package com.example.demo.service;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2022-07-08 17:15
 * @LastEditTime: 2022-07-08 17:15
 */

public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource)
            throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if(sourceName != null
            &&(sourceName.endsWith(".yml") || sourceName.endsWith(".yaml"))){
            //把yml轉換為properties
            Properties propertiesFromYaml = loadYml(resource);
            //將yml配置轉乘Properties 之後,再用PropertiesPropertSource綁定
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        }else{
            return super.createPropertySource(name, resource);
        }

    }
    private Properties loadYml(EncodedResource resource) throws IOException{
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();//這個Bean可以轉換成properties
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
