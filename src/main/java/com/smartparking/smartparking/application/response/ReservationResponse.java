package com.smartparking.smartparking.application.response;

import com.smartparking.smartparking.application.Response;
import com.smartparking.smartparking.domain.model.ParkingSpot;
import com.smartparking.smartparking.domain.model.Reservation;

public record ReservationResponse(String id, String vehicleId, String spotId, String state) implements Response {
    public static ReservationResponse of(ParkingSpot spot) {
        var reservation = spot.getReservation();
        return new ReservationResponse(spot.getId().toString(), reservation.getVehicleId(),
                spot.getId().toString(), spot.getState().toString());
    }
}
