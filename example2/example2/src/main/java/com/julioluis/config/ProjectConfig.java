package com.julioluis.config;

import com.julioluis.beans.Person;
import com.julioluis.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.julioluis")
public class ProjectConfig {

}
