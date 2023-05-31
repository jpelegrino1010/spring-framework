package com.julioluis;

import com.julioluis.beans.Vehicle;
import com.julioluis.config.ProjectConfig;
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

        Vehicle vehicle=context.getBean("honda",Vehicle.class);
        System.out.println(vehicle.getName());

        Vehicle vehicle2=context.getBean("ferrari",Vehicle.class);
        System.out.println(vehicle2.getName());
    }
}
