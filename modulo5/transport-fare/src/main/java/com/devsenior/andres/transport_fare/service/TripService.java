package com.devsenior.andres.transport_fare.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devsenior.andres.transport_fare.dto.TripDetailsResponse;
import com.devsenior.andres.transport_fare.dto.TripRequest;
import com.devsenior.andres.transport_fare.dto.TripResponse;
import com.devsenior.andres.transport_fare.model.FareType;
import com.devsenior.andres.transport_fare.model.Trip;
import com.devsenior.andres.transport_fare.repository.interfaces.ITripRepository;
import com.devsenior.andres.transport_fare.service.factory.FareStrategyFactory;
import com.devsenior.andres.transport_fare.service.interfaces.IFareStrategy;
import com.devsenior.andres.transport_fare.service.interfaces.ITripService;

@Service
public class TripService implements ITripService{
    private final ITripRepository tripRepository;

    public TripService(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    /*
    Aqui el service recibira del controlador el TripRequest (DTO)
     */
    @Override
    public TripResponse createTrip(TripRequest tripRequest){
        FareType fareType;
        try {
            fareType = FareType.valueOf(tripRequest.getFareType().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                String.format("The fare type is invalid: %s", tripRequest.getFareType()));
        }
        IFareStrategy fareStrategy = FareStrategyFactory.determinateFareStrategy(fareType);
        double totalFare = fareStrategy.calculateFare(tripRequest.getDistance(), tripRequest.getDuration());

        Trip trip = new Trip();
        trip.setDistance(tripRequest.getDistance());
        trip.setDuration(tripRequest.getDuration());
        trip.setFareType(fareType);
        trip.setTotalFare(totalFare);
        trip.setUserEmail(tripRequest.getUserEmail());
        Trip tripSave = this.tripRepository.save(trip);
        return new TripResponse(tripSave.getId(), totalFare, fareType.toString());
    }

    /*
    El service devuelve una lista de Trip (modelo). El service solo devuelve modelos. El controlador se encargará de convertir
    los modelos a DTOs antes de enviarlos al cliente
     */
    @Override
    public List<TripDetailsResponse> getTrips(){
        return this.tripRepository.findAll()
                                  .stream()
                                  .map(trip -> new TripDetailsResponse(
                                    trip.getId(), 
                                    trip.getDistance(), 
                                    trip.getDuration(), 
                                    trip.getFareType().toString(), 
                                    trip.getUserEmail(), 
                                    trip.getTotalFare()))
                                  .sorted(Comparator.comparingDouble(TripDetailsResponse::totalFare).reversed())
                                  .toList();
    }
}
