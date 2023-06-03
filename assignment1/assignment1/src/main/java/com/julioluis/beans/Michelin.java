package com.julioluis.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Michelin implements Tyres{
    @Override
    public void rotate() {
        System.out.println("roting with michelin");
    }
}
