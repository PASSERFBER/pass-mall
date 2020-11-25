package com.pas.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.pas.mall.mapper")
public class searchApp {
    public static void main(String[] args) {
        SpringApplication.run(searchApp.class,args);
    }
}
