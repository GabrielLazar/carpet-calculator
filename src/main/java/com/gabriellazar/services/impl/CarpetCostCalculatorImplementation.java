package com.gabriellazar.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriellazar.data.Constants;
import com.gabriellazar.exception.DataNotFoundException;
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
        Calculator calculator = new Calculator();
        ObjectMapper objectMapper = new ObjectMapper();
        String city = carpet.getCity();
        if(cityService.isValidCity(city)){
            if(carpet.getShape().containsKey("circle")){
                CircleShape circleShape = objectMapper.convertValue(carpet.getShape().get("circle"),CircleShape.class);
                if(CommonUtils.isMoreThanZero(circleShape.getRadius())){

                    int radius = circleShape.getRadius();
                    double tax = cityService.getStateTaxByCity(city);
                    double price = cityService.getPriceByCity(city);
                    double area = Constants.PI * (radius * radius);
                    double priceBeforeTaxes = area * price;
                    double stateTaxes = priceBeforeTaxes * (tax/100);
                    double finalPrice = priceBeforeTaxes + stateTaxes;

                    calculator.setCity(city);
                    calculator.setState(States.getState(city).toString());
                    calculator.setShape("circle");
                    calculator.setArea(area);
                    calculator.setPriceBeforeTaxes(priceBeforeTaxes);
                    calculator.setStateTax(stateTaxes);
                    calculator.setFinalPrice(finalPrice);
                } else {
                    throw new DataNotFoundException("Number must be over 0.");
                }
            } else if(carpet.getShape().containsKey("rectangle")){
                RectangleShape rectangleShape = (RectangleShape) carpet.getShape().get("rectangle");
            }
        } else {
            throw new DataNotFoundException("City was not found with name :: " + city);
        }
        return calculator;
    }
}
