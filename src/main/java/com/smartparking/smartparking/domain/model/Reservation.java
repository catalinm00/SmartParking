package com.smartparking.smartparking.domain.model;

import java.util.UUID;

public class Reservation {
    private final UUID reservationId;
    private final String vehicleId;

    public Reservation(String vehicleId) {
        this.vehicleId = vehicleId;
        this.reservationId = UUID.randomUUID();
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public boolean ownedBy(String vehicleId) {
        return this.vehicleId.equals(vehicleId);
    }
}
