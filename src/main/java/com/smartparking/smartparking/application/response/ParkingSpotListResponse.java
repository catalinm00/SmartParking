package com.smartparking.smartparking.application.response;

import com.smartparking.smartparking.application.Response;
import com.smartparking.smartparking.domain.model.ParkingSpot;

import java.util.List;

public record ParkingSpotListResponse(List<ParkingSpot> parkingSpots) implements Response {
    public static ParkingSpotListResponse of(List<ParkingSpot> parkingSpots) {
        return new ParkingSpotListResponse(parkingSpots);
    }
}
