package com.devsenior.andres.transport_fare.service.interfaces;

import java.util.List;

import com.devsenior.andres.transport_fare.dto.TripRequest;
import com.devsenior.andres.transport_fare.model.Trip;

public interface ITripService {
    Trip createTrip(TripRequest tripRequest);
    List<Trip> getTrips();
}
