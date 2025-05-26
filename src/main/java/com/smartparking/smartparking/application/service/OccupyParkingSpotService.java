package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseCommand;
import com.smartparking.smartparking.application.command.OccupyParkingSpotCommand;
import com.smartparking.smartparking.application.response.VoidResponse;
import com.smartparking.smartparking.domain.exception.ParkingSpotNotFoundException;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OccupyParkingSpotService implements UseCaseCommand<VoidResponse, OccupyParkingSpotCommand> {
    private final ParkingSpotRepository repository;

    public OccupyParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoidResponse execute(OccupyParkingSpotCommand cmd) {
        var spot = repository.findById(cmd.spotId())
                .orElseThrow(ParkingSpotNotFoundException::new);
        spot.occupy(cmd.vehicleId());
        repository.save(spot);
        return new VoidResponse();
    }
}
