package com.smartparking.smartparking.application.command;

import com.smartparking.smartparking.application.Command;
import com.smartparking.smartparking.domain.event.ParkingSpotFreedEvent;
import com.smartparking.smartparking.infrastructure.request.OccupyParkingSpotRequest;

public record OccupyParkingSpotCommand(String spotId, String vehicleId) implements Command {
    public static OccupyParkingSpotCommand of(OccupyParkingSpotRequest request) {
        return new OccupyParkingSpotCommand(request.spotId(), request.vehicleId());
    }

    public static OccupyParkingSpotCommand of(ParkingSpotFreedEvent event) {
        return new OccupyParkingSpotCommand(event.vehicleId(), event.spotId());
    }
}
