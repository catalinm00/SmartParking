package com.smartparking.smartparking.application.query;

import com.smartparking.smartparking.application.Query;

public record FindFreeSpotsByRoadSegmentQuery(String roadSegment) implements Query {
}
