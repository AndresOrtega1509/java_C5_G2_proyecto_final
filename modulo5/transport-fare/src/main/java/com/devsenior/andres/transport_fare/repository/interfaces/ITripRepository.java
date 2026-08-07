package com.devsenior.andres.transport_fare.repository.interfaces;

import java.util.List;

import com.devsenior.andres.transport_fare.model.Trip;

public interface ITripRepository {
    Trip save(Trip trip);
    List<Trip> findAll();
}
