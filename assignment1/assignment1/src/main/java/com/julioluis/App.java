package com.julioluis;

import com.julioluis.beans.Speakers;
import com.julioluis.beans.Tyres;
import com.julioluis.beans.Vehicle;
import com.julioluis.config.ProjectConfig;
import com.julioluis.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle=context.getBean(Vehicle.class);
        vehicle.getVehicleServices().playMusic();
        vehicle.getVehicleServices().rotate();


    }
}
