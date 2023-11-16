package com.julioluis.config;

import com.julioluis.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration

@ComponentScan(basePackages = "com.julioluis")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Audi 8");

        return vehicle;
    }
}
