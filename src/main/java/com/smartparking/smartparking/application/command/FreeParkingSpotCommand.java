package com.smartparking.smartparking.application.command;

import com.smartparking.smartparking.application.Command;
import com.smartparking.smartparking.domain.event.ParkingSpotFreedEvent;
import com.smartparking.smartparking.infrastructure.request.FreeParkingSpotRequest;

public record FreeParkingSpotCommand(String spotId, String vehicleId) implements Command {
    public static FreeParkingSpotCommand of(FreeParkingSpotRequest request) {
        return new FreeParkingSpotCommand(request.spotId(), request.vehicleId());
    }

    public static FreeParkingSpotCommand of(ParkingSpotFreedEvent event) {
        return new FreeParkingSpotCommand(event.spotId(), event.vehicleId());
    }
}
