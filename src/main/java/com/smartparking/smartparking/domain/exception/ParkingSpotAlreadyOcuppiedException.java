package com.smartparking.smartparking.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ParkingSpotAlreadyOcuppiedException extends RuntimeException {
    public ParkingSpotAlreadyOcuppiedException() {
        super("Parking Spot Already Occupied");
    }
}
