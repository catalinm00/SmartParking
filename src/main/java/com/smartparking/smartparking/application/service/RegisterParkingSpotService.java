package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseCommand;
import com.smartparking.smartparking.application.command.RegisterParkingSpotCommand;
import com.smartparking.smartparking.application.response.ParkingSpotResponse;
import com.smartparking.smartparking.domain.model.ParkingSpot;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterParkingSpotService
        implements UseCaseCommand<ParkingSpotResponse, RegisterParkingSpotCommand> {
    private final ParkingSpotRepository parkingSpotRepository;

    public RegisterParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }


    @Override
    public ParkingSpotResponse execute(RegisterParkingSpotCommand cmd) {
        var spot = new ParkingSpot(cmd.id(), cmd.roadSegment());
        parkingSpotRepository.save(spot);
        return ParkingSpotResponse.of(spot);
    }
}
