package com.smartparking.smartparking.application.service;

import com.smartparking.smartparking.application.UseCaseCommand;
import com.smartparking.smartparking.application.command.ReserveParkingSpotCommand;
import com.smartparking.smartparking.application.response.ReservationResponse;
import com.smartparking.smartparking.domain.event.ParkingSpotReservedEvent;
import com.smartparking.smartparking.domain.exception.ParkingSpotNotFoundException;
import com.smartparking.smartparking.domain.repository.ParkingSpotRepository;
import com.smartparking.smartparking.infrastructure.messaging.Publisher;
import com.smartparking.smartparking.infrastructure.messaging.aws.publisher.ParkingSpotReservedPublisher;
import org.springframework.stereotype.Service;

@Service
public class ReserveParkingSpotService implements UseCaseCommand<ReservationResponse, ReserveParkingSpotCommand> {
    private final ParkingSpotRepository repository;
    private final Publisher publisher;

    public ReserveParkingSpotService(ParkingSpotRepository repository,
                                     ParkingSpotReservedPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }


    @Override
    public ReservationResponse execute(ReserveParkingSpotCommand cmd) {
        var spot = repository.findById(cmd.spotId())
                .orElseThrow(ParkingSpotNotFoundException::new);
        spot.reserve(cmd.vehicleId());
        repository.save(spot);
        publisher.publish(ParkingSpotReservedEvent.of(spot));
        return ReservationResponse.of(spot);
    }
}
