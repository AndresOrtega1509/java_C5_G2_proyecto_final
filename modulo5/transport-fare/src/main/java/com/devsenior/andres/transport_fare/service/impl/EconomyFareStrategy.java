package com.devsenior.andres.transport_fare.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.andres.transport_fare.service.IFareStrategy;

@Component
public class EconomyFareStrategy implements IFareStrategy{
    private static final double COST_KM = 1.0;
    private static final double COST_MINUTE = 0.5;

    @Override
    public double calculateFare(double distance, double duration) {
        return COST_KM * distance + COST_MINUTE * duration;
    }
}
