package com.jia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun8003 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8003.class, args);
    }
}
