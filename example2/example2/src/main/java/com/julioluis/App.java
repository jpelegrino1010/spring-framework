package com.julioluis;

import com.julioluis.beans.Person;
import com.julioluis.beans.Vehicle;
import com.julioluis.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person=context.getBean(Person.class);
        Vehicle vehicle=context.getBean(Vehicle.class);

        System.out.println(person.getName());
        System.out.println(vehicle.getName());
        System.out.println(person.getVehicle());


    }
}
