package com.julioluis.config;

import com.julioluis.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean(name = "audi")
    public Vehicle vehicle1() {
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Audi");

        return vehicle;
    }

    @Bean(name = "honda")
    public Vehicle vehicle2() {
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Honda");

        return vehicle;
    }

    @Bean(name = "ferrari")
    public Vehicle vehicle3() {
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Ferrari");

        return vehicle;
    }
}
