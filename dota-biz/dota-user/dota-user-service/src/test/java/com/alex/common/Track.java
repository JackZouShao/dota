package com.alex.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Track implements Comparable<Track> {

    private String name;
    private Integer length;

    @Override
    public int compareTo(@NotNull Track track) {
        if(track == this){
            return 0;
        }
        if(track.getLength() > this.getLength()){
            return 1;
        }
        return -1;
    }
}
