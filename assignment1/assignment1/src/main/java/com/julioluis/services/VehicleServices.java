package com.julioluis.services;

import com.julioluis.beans.Speakers;
import com.julioluis.beans.Tyres;
import com.julioluis.beans.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServices {

    @Autowired
   private Speakers speakers;
    private Tyres tyres;

    public void playMusic() {
        speakers.makeSound();
    }

    public void rotate() {
        tyres.rotate();
    }



    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
