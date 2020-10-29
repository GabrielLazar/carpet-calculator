package com.gabriellazar.services.impl;

import com.gabriellazar.data.Constants;
import com.gabriellazar.data.PriceListDataGenerator;
import com.gabriellazar.models.States;
import com.gabriellazar.services.CityService;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class CityServiceImplementation implements CityService {


    @Override
    public boolean isValidCity(String city) {
        if (!States.hasCity(city)) {
           return false;
        }
        return true;
    }

    @Override
    public double getPriceByCity(String city) {
      Map<String, Double> priceList =  PriceListDataGenerator.getPriceList();
      return priceList.get(city);
    }

    @Override
    public double getStateTaxByCity(String city) {

        switch (States.getState(city)){
            case TX:
                return Constants.TX_TAX;
            case VA:
                return Constants.VA_TAX;
            default:
                return 0.0;
        }
    }
}
