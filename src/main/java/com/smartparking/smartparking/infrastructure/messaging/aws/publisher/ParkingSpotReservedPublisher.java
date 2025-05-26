package com.smartparking.smartparking.infrastructure.messaging.aws.publisher;

import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartparking.smartparking.domain.event.ParkingSpotReservedEvent;
import com.smartparking.smartparking.infrastructure.messaging.Publisher;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotReservedPublisher extends AwsIotPublisher
        implements Publisher<ParkingSpotReservedEvent> {

    private static final String TOPIC = "smartbollard/%s/command/reserve";

    public ParkingSpotReservedPublisher(AWSIotMqttClient awsIotClient, ObjectMapper objectMapper) {
        super(awsIotClient, objectMapper);
    }

    @Override
    public void publish(ParkingSpotReservedEvent event) {
        var topic = TOPIC.formatted(event.spotId());
        log.info("Publishing event {}", event);
        super.publish(event, topic);
    }
}
