package com.gabriellazar.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        Calculator calculator = null;
        String city = carpet.getCity().substring(0, carpet.getCity().indexOf(" "));
        if (cityService.isValidCity(city)) {
            if (carpet.getShape().getRadius() != 0) {

                int radius = carpet.getShape().getRadius();
                double tax = cityService.getStateTaxByCity(city);
                double price = cityService.getPriceByCity(city);
                double area = Constants.PI * (radius * radius);
                double priceBeforeTaxes = area * price;
                double stateTaxes = priceBeforeTaxes * (tax / 100);
                double finalPrice = priceBeforeTaxes + stateTaxes;

                calculator = Calculator.builder()
                        .city(city)
                        .state(cityService.getStateByCity(city))
                        .shape("circle")
                        .area(CommonUtils.formatDouble(area))
                        .priceBeforeTaxes("$" + CommonUtils.formatDouble(priceBeforeTaxes))
                        .stateTax("$" + CommonUtils.formatDouble(stateTaxes))
                        .finalPrice("$" + CommonUtils.formatDouble(finalPrice))
                        .build();

            } else if (carpet.getShape().getLength() != 0 && carpet.getShape().getWidth() != 0) {

                int length = carpet.getShape().getLength();
                int width = carpet.getShape().getWidth();
                double tax = cityService.getStateTaxByCity(city);
                double price = cityService.getPriceByCity(city);
                double area = length * width;
                double priceBeforeTaxes = area * price;
                double stateTaxes = priceBeforeTaxes * (tax / 100);
                double finalPrice = priceBeforeTaxes + stateTaxes;

                calculator = Calculator.builder()
                        .city(city)
                        .state(cityService.getStateByCity(city))
                        .shape("rectangle")
                        .area(CommonUtils.formatDouble(area))
                        .priceBeforeTaxes("$" + CommonUtils.formatDouble(priceBeforeTaxes))
                        .stateTax("$" + CommonUtils.formatDouble(stateTaxes))
                        .finalPrice("$" + CommonUtils.formatDouble(finalPrice))
                        .build();

            } else if (carpet.getShape().getBase() != 0 && carpet.getShape().getHeight() != 0) {

                int base = carpet.getShape().getBase();
                int height = carpet.getShape().getHeight();
                double tax = cityService.getStateTaxByCity(city);
                double price = cityService.getPriceByCity(city);
                double area = (base * height) / 2f;
                double priceBeforeTaxes = area * price;
                double stateTaxes = priceBeforeTaxes * (tax / 100);
                double finalPrice = priceBeforeTaxes + stateTaxes;

                calculator = Calculator.builder()
                        .city(city)
                        .state(cityService.getStateByCity(city))
                        .shape("triangle")
                        .area(CommonUtils.formatDouble(area))
                        .priceBeforeTaxes("$" + CommonUtils.formatDouble(priceBeforeTaxes))
                        .stateTax("$" + CommonUtils.formatDouble(stateTaxes))
                        .finalPrice("$" + CommonUtils.formatDouble(finalPrice))
                        .build();

            } else {
                throw new InvalidDataException("Shape is not in the format of circle, rectangle or triangle.");
            }
        } else {
            throw new InvalidDataException("City was not found with name :: " + city);
        }
        return calculator;
    }
}
