package com.julioluis.beans;

import com.julioluis.services.VehicleServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;
    private VehicleServices vehicleServices;


    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        this.vehicleServices=vehicleServices;
    }

    @PostConstruct
    public void initialize() {
        this.name="Audi";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleServices getVehicleServices() {
        return vehicleServices;
    }
}
