package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriangleShape {

    @JsonProperty("base")
    private int base;
    @JsonProperty("height")
    private int height;

    @JsonProperty("base")
    public int getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(int base) {
        this.base = base;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }
}
