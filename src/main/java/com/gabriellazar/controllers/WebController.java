package com.gabriellazar.controllers;

import com.gabriellazar.models.Calculator;
import com.gabriellazar.models.Carpet;
import com.gabriellazar.services.CarpetCostCalculatorService;
import com.gabriellazar.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    CityService cityService;
    CarpetCostCalculatorService carpetCostCalculatorService;

    @Autowired
    public WebController(CarpetCostCalculatorService carpetCostCalculatorService,CityService cityService) {
        this.carpetCostCalculatorService = carpetCostCalculatorService;
        this.cityService = cityService;
    }


    @GetMapping
    @RequestMapping("/")
    public String getHome(Model model){

        model.addAttribute("cities",cityService.getCities());
        model.addAttribute("carpet", new Carpet());
        return "index";
    }

    @PostMapping("/confirmation")
    public String postCarpet(@ModelAttribute("carpet") Carpet carpet, Model model){

        Calculator calculator = carpetCostCalculatorService.carpetCostCalculator(carpet);
        model.addAttribute("calculator",calculator);
        return "confirmation";
    }
}
