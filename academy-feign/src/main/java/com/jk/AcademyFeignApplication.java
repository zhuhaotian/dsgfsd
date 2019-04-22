package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableFeignClients
@EnableEurekaClient
public class AcademyFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademyFeignApplication.class, args);
    }

}
