package com.devsenior.andres.transport_fare.service.factory;

import org.springframework.stereotype.Component;

import com.devsenior.andres.transport_fare.model.FareType;
import com.devsenior.andres.transport_fare.service.impl.EconomyFareStrategy;
import com.devsenior.andres.transport_fare.service.impl.PremiumFareStrategy;
import com.devsenior.andres.transport_fare.service.impl.SurgeFareStrategy;
import com.devsenior.andres.transport_fare.service.interfaces.IFareStrategy;

@Component
public class FareStrategyFactory {
    public static IFareStrategy determinateFareStrategy(FareType fareType) {
        switch (fareType) {
            case ECONOMY:
                return new EconomyFareStrategy();
            case PREMIUM:
                return new PremiumFareStrategy();  
            case SURGE:
                return new SurgeFareStrategy();      
            default:
                throw new IllegalArgumentException("Invalid fare type: " + fareType);
        }
    }
}
