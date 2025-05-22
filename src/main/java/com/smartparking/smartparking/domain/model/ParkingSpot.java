package com.smartparking.smartparking.domain.model;

import com.smartparking.smartparking.domain.exception.ParkingSpotAlreadyOcuppiedException;
import com.smartparking.smartparking.domain.exception.ParkingSpotAlreadyReservedException;
import com.smartparking.smartparking.domain.exception.ReservationNotOwnedByVehicleException;

import java.util.UUID;

public class ParkingSpot {
    private final UUID id;
    private SpotState state;
    private final String roadSegment;
    private Reservation reservation;

    public ParkingSpot(String roadSegment) {
        this.id = UUID.randomUUID();
        this.state = SpotState.FREE;
        this.roadSegment = roadSegment;
    }

    public UUID getId() {
        return id;
    }

    public SpotState getState() {
        return state;
    }

    public String getRoadSegment() {
        return roadSegment;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void reserve(String vehicleId) {
        if (state == SpotState.RESERVED) {
            throw new ParkingSpotAlreadyReservedException();
        }
        if (state == SpotState.OCCUPIED) {
            throw new ParkingSpotAlreadyOcuppiedException();
        }
        reservation  = new Reservation(vehicleId);
        state = SpotState.RESERVED;
    }

    public void occupy(String vehicleId) {
        if (state == SpotState.OCCUPIED) {
            throw new ParkingSpotAlreadyOcuppiedException();
        }
        state = SpotState.OCCUPIED;
    }

    public void free(String vehicleId) {
        if (!reservation.ownedBy(vehicleId)) {
            throw new ReservationNotOwnedByVehicleException();
        }
        removeCurrentReservation();
    }

    private void removeCurrentReservation() {
        this.reservation = null;
        this.state = SpotState.FREE;
    }
}
