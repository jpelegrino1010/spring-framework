package com.julioluis.beans;

import org.springframework.stereotype.Component;

@Component
public class BridgeStone implements Tyres{
    @Override
    public void rotate() {
        System.out.println("Roting with bridge stone");
    }
}
