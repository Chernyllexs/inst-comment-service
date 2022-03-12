package com.chernyllexs.comments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InstCommentsService {
    public static void main(String[] args) {
        SpringApplication.run(InstCommentsService.class);
    }
}
