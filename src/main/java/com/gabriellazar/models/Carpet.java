package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Carpet {

    @JsonIgnore
    private Map<String, Object> shape;
    @JsonProperty("city")
    private String city;


    public Carpet(Map<String, Object> shape, String city) {
        this.shape = shape;
        this.city = city;

    }

    public Carpet(){

    }

    @JsonAnyGetter
    public Map<String, Object> getShape() {
        return shape;
    }

    @JsonAnySetter
    public void setShape(String key, Object value) {
        if (this.shape == null) {
            this.shape = new HashMap<>();
        }
        this.shape.put(key,value);
    }


    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

}