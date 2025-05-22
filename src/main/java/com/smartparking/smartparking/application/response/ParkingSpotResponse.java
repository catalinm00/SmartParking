package com.smartparking.smartparking.application.response;

import com.smartparking.smartparking.application.Response;
import com.smartparking.smartparking.domain.model.ParkingSpot;

public record ParkingSpotResponse(ParkingSpot spot) implements Response {
    public static ParkingSpotResponse of(ParkingSpot spot) {
        return new ParkingSpotResponse(spot);
    }
}
