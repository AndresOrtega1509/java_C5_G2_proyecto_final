package com.devsenior.andres.transport_fare.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.andres.transport_fare.model.Trip;
import com.devsenior.andres.transport_fare.repository.interfaces.ITripRepository;

@Repository
public class TripRepository implements ITripRepository{
    private final List<Trip> trips = new ArrayList<>();
    private Long idCounter = 1L;

    //agregamos un id manualmente
    @Override
    public Trip save(Trip trip){
        trip.setId(idCounter++);
        this.trips.add(trip);
        return trip;
    }

    @Override
    public List<Trip> findAll(){
        return this.trips;
    }
}
