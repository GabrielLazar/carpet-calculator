package com.gabriellazar.services;

import com.gabriellazar.models.Calculator;
import com.gabriellazar.models.Carpet;
import com.gabriellazar.models.Shape;

import java.util.Map;

public interface CarpetCostCalculatorService {

  Calculator carpetCostCalculator(Carpet carpet);

  Map<String, Double> getArea(Shape carpetShape);

}
