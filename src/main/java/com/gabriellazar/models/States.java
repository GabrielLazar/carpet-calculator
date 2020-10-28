package com.gabriellazar.models;
import java.util.*;

public enum States {
    VA("Arlington","Fairfax","McLean"),
    TX("Dallas","Austin","San Antonio");

    private  String [] cities;
    static final private Map<String,States> mapOfCities = new HashMap<>();

    States(String ... cities) {
       this.cities = cities;
    }



}
