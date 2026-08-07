package com.devsenior.andres.transport_fare.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.andres.transport_fare.dto.TripDetailsResponse;
import com.devsenior.andres.transport_fare.dto.TripRequest;
import com.devsenior.andres.transport_fare.dto.TripResponse;
import com.devsenior.andres.transport_fare.service.interfaces.ITripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final ITripService tripService;

    public TripController(ITripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<TripDetailsResponse>> getTrips(){
        return ResponseEntity.ok(tripService.getTrips());
    }

    @PostMapping
    public ResponseEntity<TripResponse> createTrip(@Valid @RequestBody TripRequest tripRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(tripService.createTrip(tripRequest));
    }
}
