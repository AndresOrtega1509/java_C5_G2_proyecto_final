package com.devsenior.andres.transport_fare.model;

public class Trip {
    private Long id;
    private double distance;
    private double duration;
    private FareType fareType;
    private String userEmail;
    private double totalFare;

    public Trip() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public FareType getFareType() {
        return fareType;
    }

    public void setFareType(FareType fareType) {
        this.fareType = fareType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return "Trip [id=" + id + ", distance=" + distance + ", duration=" + duration + ", fareType=" + fareType
                + ", userEmail=" + userEmail + ", totalFare=" + totalFare + "]";
    }
}
