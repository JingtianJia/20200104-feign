package com.jia.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @GetMapping("/test")
    public String test(){
        return port+"-----"+driverClass;
    }
}
