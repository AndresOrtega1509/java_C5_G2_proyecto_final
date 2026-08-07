package com.devsenior.andres.transport_fare.dto;

public record TripDetailsResponse(Long id, 
                                double distance, 
                                double duration, 
                                String fareType, 
                                String userEmail, 
                                double totalFare) {}
