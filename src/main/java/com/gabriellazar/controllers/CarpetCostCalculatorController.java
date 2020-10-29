package com.gabriellazar.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriellazar.models.Calculator;
import com.gabriellazar.models.Carpet;
import com.gabriellazar.models.CircleShape;
import com.gabriellazar.services.CarpetCostCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("api/v1/calculator")
public class CarpetCostCalculatorController {

    CarpetCostCalculatorService carpetCostCalculatorService;

    @Autowired
    public CarpetCostCalculatorController(CarpetCostCalculatorService carpetCostCalculatorService) {
        this.carpetCostCalculatorService = carpetCostCalculatorService;
    }

    @PostMapping
    public ResponseEntity<Calculator> calculateCarpetPrice(@RequestBody Carpet carpet) {

        Calculator calculator = carpetCostCalculatorService.carpetCostCalculator(carpet);

        return ResponseEntity.status(HttpStatus.OK).body(calculator);
    }
}