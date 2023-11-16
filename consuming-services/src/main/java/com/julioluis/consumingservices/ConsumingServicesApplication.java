package com.julioluis.consumingservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.julioluis.consumingservices.proxy")
public class ConsumingServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingServicesApplication.class, args);
    }

}
