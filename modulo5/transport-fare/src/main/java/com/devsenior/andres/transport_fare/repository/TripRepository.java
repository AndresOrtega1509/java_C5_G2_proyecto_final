package com.devsenior.andres.transport_fare.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.andres.transport_fare.model.Trip;

@Repository
public class TripRepository {
    private final List<Trip> trips = new ArrayList<>();
    private Long idCounter = 1L;

    //agregamos un id manualmente
    public Trip save(Trip trip){
        trip.setId(idCounter++);
        this.trips.add(trip);
        return trip;
    }

    public List<Trip> findAll(){
        return this.trips;
    }
}
