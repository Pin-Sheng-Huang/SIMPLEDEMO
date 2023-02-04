//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
///**
// * @program: demo
// * @description:
// * @Creator: 阿昇
// * @CreateTime: 2022-07-13 14:29
// * @LastEditTime: 2022-07-13 14:29
// */
//@Configuration//配置類
//public class DataSourceConfig {
//    @Primary
//    @Bean("primaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.primary")
//    public DataSource primaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Bean("secondaryDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.secondary")
//    public DataSource secondaryDataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Bean("primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){//@Qualifier 合格者
//        return new JdbcTemplate(dataSource);
//    }
//    @Bean("secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource){//@Qualifier 合格者
//        return new JdbcTemplate(dataSource);
//    }
//}
