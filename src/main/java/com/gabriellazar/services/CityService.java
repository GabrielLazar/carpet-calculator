package com.gabriellazar.services;


import java.util.List;

public interface CityService {

    boolean isValidCity(String city);

    double getPriceByCity(String city);

    double getStateTaxByCity(String city);

    String getStateByCity(String city);

    List<String> getCities();

}
