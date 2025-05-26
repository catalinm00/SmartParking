package com.smartparking.smartparking.domain.event;

import com.smartparking.smartparking.domain.Event;
import com.smartparking.smartparking.domain.model.ParkingSpot;

public record ParkingSpotOcuppiedEvent(String spotId, String vehicleId) implements Event {
    public static ParkingSpotOcuppiedEvent of(ParkingSpot spot) {
        return new ParkingSpotOcuppiedEvent(spot.getId(), spot.getReservation().getVehicleId());
    }
}
