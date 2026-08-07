package com.devsenior.andres.transport_fare.dto;

public record TripResponse(Long id, 
                        double totalFare, 
                        String fareType) {}
