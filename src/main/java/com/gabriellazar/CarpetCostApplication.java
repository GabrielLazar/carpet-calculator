package com.gabriellazar;

import com.gabriellazar.models.Calculator;
import com.gabriellazar.models.Carpet;
import com.gabriellazar.models.CircleShape;
import com.gabriellazar.models.States;
import com.gabriellazar.services.CarpetCostCalculatorService;
import com.gabriellazar.services.impl.CarpetCostCalculatorImplementation;
import com.gabriellazar.services.impl.CityServiceImplementation;
import com.gabriellazar.utils.CommonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CarpetCostApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarpetCostApplication.class, args);
    }

}
