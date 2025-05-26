package com.smartparking.smartparking.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ReservationNotOwnedByVehicleException extends RuntimeException {
    public ReservationNotOwnedByVehicleException() {
        super("Reservation Not Owned By Vehicle");
    }
}
