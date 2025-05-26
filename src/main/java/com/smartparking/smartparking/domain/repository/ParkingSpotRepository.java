package com.smartparking.smartparking.domain.repository;

import com.smartparking.smartparking.domain.model.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingSpotRepository {
    Optional<ParkingSpot> findById(String id);
    List<ParkingSpot> findFreeSpotsByRoadSegment(String roadSegment);
    ParkingSpot delete(ParkingSpot parkingSpot);
    ParkingSpot save(ParkingSpot parkingSpot);
}
