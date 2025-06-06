package com.smartparking.smartparking.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ParkingSpotAlreadyReservedException extends RuntimeException {
    public ParkingSpotAlreadyReservedException() {
        super("Parking Spot is already reserved");
    }
}
