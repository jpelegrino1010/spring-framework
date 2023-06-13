package com.julioluis.impl;

import com.julioluis.beans.Song;
import com.julioluis.tre.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {
    @Override
    public String makeSound(Song song) {
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Sony speakers";
    }
}
