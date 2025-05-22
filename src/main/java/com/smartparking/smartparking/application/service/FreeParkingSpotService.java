package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseCommand;
import com.smartparking.smartparking.application.command.FreeParkingSpotCommand;
import com.smartparking.smartparking.application.command.OccupyParkingSpotCommand;
import com.smartparking.smartparking.application.response.VoidResponse;
import com.smartparking.smartparking.domain.exception.ParkingSpotNotFoundException;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FreeParkingSpotService implements UseCaseCommand<VoidResponse, FreeParkingSpotCommand> {
    private final ParkingSpotRepository repository;

    public FreeParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoidResponse execute(FreeParkingSpotCommand cmd) {
        var spot = repository.findById(UUID.fromString(cmd.spotId()))
                .orElseThrow(ParkingSpotNotFoundException::new);
        spot.free(cmd.vehicleId());
        repository.save(spot);
        return new VoidResponse();
    }
}
