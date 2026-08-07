package com.devsenior.andres.transport_fare.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.andres.transport_fare.service.interfaces.IFareStrategy;

@Component
public class SurgeFareStrategy implements IFareStrategy{
    private static final double COST_KM = 1.5;
    private static final double COST_MINUTE = 0.75;

    @Override
    public double calculateFare(double distance, double duration) {
        return (COST_KM * distance + COST_MINUTE * duration) * COST_KM;
    }
}
