package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseCommand;
import com.smartparking.smartparking.application.command.ReserveParkingSpotCommand;
import com.smartparking.smartparking.application.response.ReservationResponse;
import com.smartparking.smartparking.application.response.VoidResponse;
import com.smartparking.smartparking.domain.exception.ParkingSpotNotFoundException;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReserveParkingSpotService implements UseCaseCommand<ReservationResponse, ReserveParkingSpotCommand> {
    private final ParkingSpotRepository repository;

    public ReserveParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }


    @Override
    public ReservationResponse execute(ReserveParkingSpotCommand cmd) {
        var spot = repository.findById(cmd.spotId())
                .orElseThrow(ParkingSpotNotFoundException::new);
        spot.reserve(cmd.vehicleId());
        repository.save(spot);
        return ReservationResponse.of(spot);
    }
}
