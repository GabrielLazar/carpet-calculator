package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RectangleShape {

    @JsonProperty("length")
    private int length;
    @JsonProperty("width")
    private int width;

    @JsonProperty("length")
    public int getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(int length) {
        this.length = length;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }
}
