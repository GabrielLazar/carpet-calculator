package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CircleShape {

    @JsonProperty("radius")
    private int radius;

    @JsonProperty("radius")
    public int getRadius() {
        return radius;
    }
    @JsonProperty("radius")
    public void setRadius(int radius) {
        this.radius = radius;
    }

}