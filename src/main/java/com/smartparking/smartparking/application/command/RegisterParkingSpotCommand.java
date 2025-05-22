package com.smartparking.smartparking.application.command;

import com.smartparking.smartparking.application.Command;
import com.smartparking.smartparking.infrastructure.request.RegisterParkingSpotRequest;

public record RegisterParkingSpotCommand(String roadSegment) implements Command {
    public static RegisterParkingSpotCommand of(RegisterParkingSpotRequest request) {
        return new RegisterParkingSpotCommand(request.roadSegment());
    }
}
