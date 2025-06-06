package com.smartparking.smartparking.infrastructure.repository;

import com.smartparking.smartparking.domain.model.ParkingSpot;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class ParkingSpotHashMapRepository implements ParkingSpotRepository {
    private HashMap<String, ParkingSpot> map = new HashMap<>();

    @Override
    public Optional<ParkingSpot> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<ParkingSpot> findFreeSpotsByRoadSegment(String roadSegment) {
        return map.values().stream()
                .filter(
                        spot -> spot.getRoadSegment().equals(roadSegment) && spot.isFree()
                )
                .toList();
    }

    @Override
    public ParkingSpot delete(ParkingSpot parkingSpot) {
        return map.remove(parkingSpot.getId());
    }

    @Override
    public ParkingSpot save(ParkingSpot parkingSpot) {
        return map.put(parkingSpot.getId(), parkingSpot);
    }
}
