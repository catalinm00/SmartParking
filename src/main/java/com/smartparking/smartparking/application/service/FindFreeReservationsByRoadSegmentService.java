package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseQuery;
import com.smartparking.smartparking.application.query.FindFreeSpotsByRoadSegmentQuery;
import com.smartparking.smartparking.application.response.ParkingSpotListResponse;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class FindFreeReservationsByRoadSegmentService implements UseCaseQuery<ParkingSpotListResponse, FindFreeSpotsByRoadSegmentQuery> {
    private final ParkingSpotRepository parkingSpotRepository;

    public FindFreeReservationsByRoadSegmentService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }


    @Override
    public ParkingSpotListResponse execute(FindFreeSpotsByRoadSegmentQuery query) {
        var response = parkingSpotRepository.findFreeSpotsByRoadSegment(query.roadSegment());
        return ParkingSpotListResponse.of(response);
    }
}
