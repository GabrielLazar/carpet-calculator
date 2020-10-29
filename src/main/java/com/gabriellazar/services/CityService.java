package com.gabriellazar.services;

import org.springframework.stereotype.Component;


public interface CityService {

    boolean isValidCity(String city);

    double getPriceByCity(String city);

    double getStateTaxByCity(String city);
}
