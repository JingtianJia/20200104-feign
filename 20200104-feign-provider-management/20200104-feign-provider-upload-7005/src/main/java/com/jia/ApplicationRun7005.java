package com.jia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.jia.mapper")
public class ApplicationRun7005 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7005.class, args);
    }
}
