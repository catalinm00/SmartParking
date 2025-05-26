package com.smartparking.smartparking.domain.event;

import com.smartparking.smartparking.domain.Event;
import com.smartparking.smartparking.domain.model.ParkingSpot;

public record ParkingSpotFreedEvent(String spotId, String vehicleId) implements Event {
    public static ParkingSpotFreedEvent of(ParkingSpot spot) {
        return new ParkingSpotFreedEvent(spot.getId(), spot.getReservation().getVehicleId());
    }
}
