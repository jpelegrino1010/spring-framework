package com.julioluis;

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

        final Vehicle honda=new Vehicle();
        honda.setName("Honda");

        Supplier<Vehicle> hondaSupplier = () -> honda;

        final Vehicle audi=new Vehicle();
        audi.setName("Audi");
        Supplier<Vehicle> audiSupplier = () -> audi;

        Random random=new Random();
        int randomNum= random.nextInt(10);

        if(randomNum%2==0) {
            context.registerBean("honda",Vehicle.class,hondaSupplier);
        }else {
            context.registerBean("audi",Vehicle.class,audiSupplier);
        }

        Vehicle hondaVehicle=null;
        Vehicle audiVehicle=null;

        System.out.println("Random number is:: "+ randomNum);

        try {
            hondaVehicle=context.getBean("honda",Vehicle.class);
        }catch (NoSuchBeanDefinitionException ex) {
            System.out.println("Error while trying to retrieve honda bean");
        }

        try {
            audiVehicle=context.getBean("audi",Vehicle.class);
        }catch (NoSuchBeanDefinitionException ex) {
            System.out.println("Error while trying to retrieve audi bean");
        }


        if(Objects.nonNull(hondaVehicle)) {
            System.out.println("Your print vehicle is "+ hondaVehicle.getName());
        }else {
            System.out.println("Your print vehicle is "+ audiVehicle.getName());
        }



    }
}
