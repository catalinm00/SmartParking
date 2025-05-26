package com.smartparking.smartparking.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParkingSpotNotFoundException extends RuntimeException {
    public ParkingSpotNotFoundException() {
        super("Parking Spot Not Found");
    }
}
