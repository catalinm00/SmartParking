package com.smartparking.smartparking.application.command;

import com.smartparking.smartparking.application.Command;
import com.smartparking.smartparking.application.service.ReserveParkingSpotService;
import com.smartparking.smartparking.infrastructure.request.ReserveParkingSpotRequest;

public record ReserveParkingSpotCommand(String spotId, String vehicleId) implements Command {
    public static ReserveParkingSpotCommand of(ReserveParkingSpotRequest request) {
        return new ReserveParkingSpotCommand(request.spotId(), request.vehicleId());
    }
}
