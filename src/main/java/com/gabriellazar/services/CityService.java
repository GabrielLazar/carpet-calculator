package com.gabriellazar.services;

public interface CityService {

    boolean isValidCity(String city);

    double getPriceByCity(String city);

    double getStateTaxByCity(String city);
}
