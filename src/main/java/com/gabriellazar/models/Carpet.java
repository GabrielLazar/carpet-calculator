package com.gabriellazar.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Carpet {

    @JsonIgnore
    private Shape shape;
    @JsonProperty("city")
    private String city;


}