package com.devsenior.andres.transport_fare.service.interfaces;

import java.util.List;

import com.devsenior.andres.transport_fare.dto.TripDetailsResponse;
import com.devsenior.andres.transport_fare.dto.TripRequest;
import com.devsenior.andres.transport_fare.dto.TripResponse;

public interface ITripService {
    TripResponse createTrip(TripRequest tripRequest);
    List<TripDetailsResponse> getTrips();
}
