package com.devsenior.andres.transport_fare.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.andres.transport_fare.dto.TripRequest;
import com.devsenior.andres.transport_fare.model.FareType;
import com.devsenior.andres.transport_fare.model.Trip;
import com.devsenior.andres.transport_fare.repository.TripRepository;
import com.devsenior.andres.transport_fare.service.factory.FareStrategyFactory;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    /*
    Aqui el service recibira del controlador el TripRequest (DTO)
     */
    public Trip createTrip(TripRequest tripRequest){
        FareType fareType = FareType.valueOf(tripRequest.getFareType());
        IFareStrategy fareStrategy = FareStrategyFactory.determinateFareStrategy(fareType);
        double totalFare = fareStrategy.calculateFare(tripRequest.getDistance(), tripRequest.getDuration());

        Trip trip = new Trip();
        trip.setDistance(tripRequest.getDistance());
        trip.setDuration(tripRequest.getDuration());
        trip.setFareType(fareType);
        trip.setTotalFare(totalFare);
        trip.setUserEmail(tripRequest.getUserEmail());
        return this.tripRepository.save(trip);
    }

    /*
    El service devuelve una lista de Trip (modelo). El service solo devuelve modelos. El controlador se encargará de convertir
    los modelos a DTOs antes de enviarlos al cliente
     */
    public List<Trip> getTrips(){
        return this.tripRepository.findAll()
                                  .stream()
                                  .sorted(Comparator.comparingDouble(Trip::getTotalFare).reversed())
                                  .toList();
    }
}
