package com.smartparking.smartparking.domain.event;

import com.smartparking.smartparking.domain.Event;
import com.smartparking.smartparking.domain.model.ParkingSpot;

public record ParkingSpotReservedEvent(String spotId, String vehicleId)
        implements Event {

    public static ParkingSpotReservedEvent of(ParkingSpot spot) {
        return new ParkingSpotReservedEvent(
                spot.getId().toString(),
                spot.getReservation().getVehicleId()
        );
    }
}
