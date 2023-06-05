package com.julioluis;

import com.julioluis.beans.Person;
import com.julioluis.beans.Vehicle;
import com.julioluis.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        AnnotationConfigApplicationContext  context=new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Before calling person bean");
        Person person=context.getBean(Person.class);
        System.out.println("After calling person bean");

    }
}
