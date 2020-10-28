package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriangleShape {

    @JsonProperty("sideA")
    private int sideA;
    @JsonProperty("sideB")
    private int sideB;
    @JsonProperty("sideC")
    private int sideC;

    @JsonProperty("sideA")
    public int getSideA() {
        return sideA;
    }

    @JsonProperty("sideA")
    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    @JsonProperty("sideB")
    public int getSideB() {
        return sideB;
    }

    @JsonProperty("sideB")
    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    @JsonProperty("sideC")
    public int getSideC() {
        return sideC;
    }

    @JsonProperty("sideC")
    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
