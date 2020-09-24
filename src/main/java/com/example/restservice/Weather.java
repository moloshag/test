package com.example.restservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private String fall;
    private int temp, wind, wet;

    public Weather (String fall, int temp, int wind, int wet) {
        this.fall = fall;
        this.temp = temp;
        this.wind = wind;
        this.wet = wet;
    }
}
