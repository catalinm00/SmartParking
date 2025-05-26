package com.smartparking.smartparking.infrastructure.messaging.aws.publisher;

import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartparking.smartparking.domain.event.ParkingSpotOcuppiedEvent;
import com.smartparking.smartparking.infrastructure.messaging.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ParkingSpotOccupiedPublisher extends AwsIotPublisher
        implements Publisher<ParkingSpotOcuppiedEvent> {

    private final static String TOPIC = "smartbollard/%s/command/occupy";

    public ParkingSpotOccupiedPublisher(AWSIotMqttClient awsIotClient, ObjectMapper objectMapper) {
        super(awsIotClient, objectMapper);
    }

    @Override
    public void publish(ParkingSpotOcuppiedEvent event) {
        var topic = TOPIC.formatted(event.spotId());
        log.info("Publishing event: {}", event);
        super.publish(event, topic);
    }
}
