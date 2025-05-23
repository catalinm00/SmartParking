package com.smartparking.smartparking.domain.repository;

import com.smartparking.smartparking.domain.model.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository {
    public Optional<ParkingSpot> findById(UUID id);
    public List<ParkingSpot> findFreeSpotsByRoadSegment(String roadSegment);
    public ParkingSpot delete(ParkingSpot parkingSpot);
    public ParkingSpot save(ParkingSpot parkingSpot);
}
