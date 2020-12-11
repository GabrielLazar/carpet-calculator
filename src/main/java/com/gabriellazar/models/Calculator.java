package com.gabriellazar.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Calculator {

    private String city;
    private String state;
    private String shape;
    private String area;
    private String priceBeforeTaxes;
    private String stateTax;
    private String finalPrice;

}
