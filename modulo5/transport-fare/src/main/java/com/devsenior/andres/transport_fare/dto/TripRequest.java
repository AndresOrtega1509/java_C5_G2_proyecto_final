package com.devsenior.andres.transport_fare.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TripRequest {
    @NotNull
    @Positive
    private Double distance;
    @NotNull
    @Positive
    private Double duration;
    @NotNull
    private String fareType;
    @NotNull
    @Email
    private String userEmail;

    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public Double getDuration() {
        return duration;
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }
    public String getFareType() {
        return fareType;
    }
    public void setFareType(String fareType) {
        this.fareType = fareType;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
