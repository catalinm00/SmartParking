package com.smartparking.smartparking.infrastructure.controller;

import com.smartparking.smartparking.application.command.FreeParkingSpotCommand;
import com.smartparking.smartparking.application.command.OccupyParkingSpotCommand;
import com.smartparking.smartparking.application.command.RegisterParkingSpotCommand;
import com.smartparking.smartparking.application.command.ReserveParkingSpotCommand;
import com.smartparking.smartparking.application.query.FindFreeSpotsByRoadSegmentQuery;
import com.smartparking.smartparking.application.response.ParkingSpotListResponse;
import com.smartparking.smartparking.application.response.ParkingSpotResponse;
import com.smartparking.smartparking.application.response.ReservationResponse;
import com.smartparking.smartparking.application.response.VoidResponse;
import com.smartparking.smartparking.application.service.*;
import com.smartparking.smartparking.infrastructure.request.FreeParkingSpotRequest;
import com.smartparking.smartparking.infrastructure.request.OccupyParkingSpotRequest;
import com.smartparking.smartparking.infrastructure.request.RegisterParkingSpotRequest;
import com.smartparking.smartparking.infrastructure.request.ReserveParkingSpotRequest;
import org.springframework.web.bind.annotation.*;

@RestController("api/v1")
public class ParkingSpotController {
    private final FindFreeReservationsByRoadSegmentService findService;
    private final OccupyParkingSpotService occupyService;
    private final ReserveParkingSpotService reserveService;
    private final FreeParkingSpotService freeParkingService;
    private final RegisterParkingSpotService registerService;

    public ParkingSpotController(FindFreeReservationsByRoadSegmentService findService,
                                 OccupyParkingSpotService occupyService,
                                 ReserveParkingSpotService reserveService,
                                 FreeParkingSpotService freeParkingService,
                                 RegisterParkingSpotService registerService) {
        this.findService = findService;
        this.occupyService = occupyService;
        this.reserveService = reserveService;
        this.freeParkingService = freeParkingService;
        this.registerService = registerService;
    }

    @GetMapping("/plazas/{roadSegment}")
    public ParkingSpotListResponse getParkingSpots(@PathVariable String roadSegment) {
        return findService.execute(new FindFreeSpotsByRoadSegmentQuery(roadSegment));
    }

    @PostMapping("/plazas")
    public ParkingSpotResponse registerParkingSpot(@RequestBody RegisterParkingSpotRequest request) {
        return registerService.execute(RegisterParkingSpotCommand.of(request));
    }

    @PostMapping("/plazas/free")
    public VoidResponse freeParkingSpot(@RequestBody FreeParkingSpotRequest request) {
        return freeParkingService.execute(FreeParkingSpotCommand.of(request));
    }

    @PostMapping("/plazas/occupy")
    public VoidResponse occupyParkingSpot(@RequestBody OccupyParkingSpotRequest request) {
        return occupyService.execute(OccupyParkingSpotCommand.of(request));
    }

    @PostMapping("/plazas/reserve")
    public ReservationResponse reserveParkingSpot(@RequestBody ReserveParkingSpotRequest request) {
        return reserveService.execute(ReserveParkingSpotCommand.of(request));
    }
}
