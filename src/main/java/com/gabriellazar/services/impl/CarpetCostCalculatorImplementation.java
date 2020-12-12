package com.gabriellazar.services.impl;


import com.gabriellazar.data.Constants;
import com.gabriellazar.exception.InvalidDataException;
import com.gabriellazar.models.*;
import com.gabriellazar.services.CarpetCostCalculatorService;
import com.gabriellazar.services.CityService;

import com.gabriellazar.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarpetCostCalculatorImplementation implements CarpetCostCalculatorService {

    private CityService cityService;

    @Autowired
    public CarpetCostCalculatorImplementation(CityService service) {
        this.cityService = service;
    }

    @Override
    public Calculator carpetCostCalculator(Carpet carpet) {

        String city = carpet.getCity().substring(0, carpet.getCity().indexOf(" "));
        String state = cityService.getStateByCity(city);
        String shape = "";
        double tax = 0;
        double price = 0;
        double area = 0;
        double priceBeforeTaxes = 0;
        double stateTaxes = 0;
        double finalPrice = 0;

        if (cityService.isValidCity(city)) {
            if (carpet.getShape().getRadius() != 0) {

                shape = "circle";
                int radius = carpet.getShape().getRadius();
                tax = cityService.getStateTaxByCity(city);
                price = cityService.getPriceByCity(city);
                area = Constants.PI * (radius * radius);
                priceBeforeTaxes = area * price;
                stateTaxes = priceBeforeTaxes * (tax / 100);
                finalPrice = priceBeforeTaxes + stateTaxes;

            } else if (carpet.getShape().getLength() != 0 && carpet.getShape().getWidth() != 0) {

                shape = "rectangle";
                int length = carpet.getShape().getLength();
                int width = carpet.getShape().getWidth();
                tax = cityService.getStateTaxByCity(city);
                price = cityService.getPriceByCity(city);
                area = length * width;
                priceBeforeTaxes = area * price;
                stateTaxes = priceBeforeTaxes * (tax / 100);
                finalPrice = priceBeforeTaxes + stateTaxes;

            } else if (carpet.getShape().getBase() != 0 && carpet.getShape().getHeight() != 0) {

                shape = "triangle";
                int base = carpet.getShape().getBase();
                int height = carpet.getShape().getHeight();
                tax = cityService.getStateTaxByCity(city);
                price = cityService.getPriceByCity(city);
                area = (base * height) / 2f;
                priceBeforeTaxes = area * price;
                stateTaxes = priceBeforeTaxes * (tax / 100);
                finalPrice = priceBeforeTaxes + stateTaxes;

            } else {
                throw new InvalidDataException("Shape is not in the format of circle, rectangle or triangle.");
            }
        } else {
            throw new InvalidDataException("City was not found with name :: " + city);
        }
        return  Calculator.builder()
                .city(city)
                .state(state)
                .shape(shape)
                .area(CommonUtils.formatDouble(area))
                .priceBeforeTaxes("$" + CommonUtils.formatDouble(priceBeforeTaxes))
                .stateTax("$" + CommonUtils.formatDouble(stateTaxes))
                .finalPrice("$" + CommonUtils.formatDouble(finalPrice))
                .build();
    }
}
