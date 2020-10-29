package com.gabriellazar.services.impl;

import com.gabriellazar.services.ShapeService;
import org.springframework.stereotype.Component;

@Component
public class ShapeServiceImplementation implements ShapeService {

    @Override
    public boolean isRequiredShape(String shape) {
        return shape.equals("circle") || shape.equals("rectangle") || shape.equals("triangle");
    }
}
