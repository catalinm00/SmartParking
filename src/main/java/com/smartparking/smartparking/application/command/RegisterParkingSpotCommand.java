package com.smartparking.smartparking.application.command;

import com.smartparking.smartparking.application.Command;
import com.smartparking.smartparking.domain.event.RegisterParkingSpotEvent;
import com.smartparking.smartparking.infrastructure.request.RegisterParkingSpotRequest;

public record RegisterParkingSpotCommand(String roadSegment, String id) implements Command {
    public static RegisterParkingSpotCommand of(RegisterParkingSpotRequest request) {
        return new RegisterParkingSpotCommand(request.roadSegment(), request.id());
    }

    public static RegisterParkingSpotCommand of(RegisterParkingSpotEvent event) {
        return new RegisterParkingSpotCommand(event.roadSegment(), event.spotId());
    }
}
