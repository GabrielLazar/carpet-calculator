package com.gabriellazar.services.impl;


import com.gabriellazar.data.Constants;
import com.gabriellazar.exception.InvalidDataException;
import com.gabriellazar.models.*;
import com.gabriellazar.services.CarpetCostCalculatorService;
import com.gabriellazar.services.CityService;

import com.gabriellazar.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarpetCostCalculatorImplementation implements CarpetCostCalculatorService {

    private CityService cityService;

    @Autowired
    public CarpetCostCalculatorImplementation(CityService service) {
        this.cityService = service;
    }

    @Override
    public Calculator carpetCostCalculator(Carpet carpet) {
        Map<String, Double> shapeArea = getArea(carpet.getShape());
        String city = carpet.getCity().substring(0, carpet.getCity().indexOf("$") - 1);

        if (!cityService.isValidCity(city)) {
            throw new InvalidDataException("City was not found with name :: " + city);
        }

        String state = cityService.getStateByCity(city);
        String shape = shapeArea.keySet().stream().findAny().get();
        double tax = cityService.getStateTaxByCity(city);
        double price = cityService.getPriceByCity(city);
        double area = shapeArea.get(shape);
        double priceBeforeTaxes = area * price;
        double stateTaxes = priceBeforeTaxes * (tax / 100);
        double finalPrice = priceBeforeTaxes + stateTaxes;

        return Calculator.builder()
                .city(city)
                .state(state)
                .shape(shape)
                .area(CommonUtils.formatDouble(area))
                .priceBeforeTaxes("$" + CommonUtils.formatDouble(priceBeforeTaxes))
                .stateTax("$" + CommonUtils.formatDouble(stateTaxes))
                .finalPrice("$" + CommonUtils.formatDouble(finalPrice))
                .build();
    }

    @Override
    public Map<String, Double> getArea(Shape carpetShape) {
        Map<String, Double> map = new HashMap<>();
        String shape = "";
        double area = 0;

        if (carpetShape.getRadius() != 0) {
            shape = "circle";
            area = Constants.PI * (carpetShape.getRadius() * carpetShape.getRadius());
        } else if (carpetShape.getLength() != 0 && carpetShape.getWidth() != 0) {
            shape = "rectangle";
            area = carpetShape.getLength() * carpetShape.getWidth();
        } else if (carpetShape.getBase() != 0 && carpetShape.getHeight() != 0) {
            shape = "triangle";
            area = (carpetShape.getBase() * carpetShape.getHeight()) / 2f;
        } else {
            throw new InvalidDataException("Shape is not in the format of circle, rectangle or triangle.");
        }
        map.put(shape, area);
        return map;
    }
}
