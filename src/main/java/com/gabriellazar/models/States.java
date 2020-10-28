package com.gabriellazar.models;
import java.util.*;

public enum States {
    VA("Arlington","Fairfax","McLean"),
    TX("Dallas","Austin","San Antonio");

    private  List<String> cities;
    static final private Map<String,States> mapOfCities = new HashMap<>();

    States(String ... cities) {
       this.cities = Arrays.asList(cities);
    }

    static{
        for(States state: States.values()){
            for(String city: state.cities){
                mapOfCities.put(city,state);
            }

        }
    }

    public static boolean hasCity(String value){

        return mapOfCities.containsKey(value);
    }

    public static States getState(String city){
       return mapOfCities.get(city);
    }


}
