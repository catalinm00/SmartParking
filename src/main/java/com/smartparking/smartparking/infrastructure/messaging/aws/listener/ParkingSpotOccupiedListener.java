package com.smartparking.smartparking.infrastructure.messaging.aws.listener;

import com.amazonaws.services.iot.client.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartparking.smartparking.application.command.OccupyParkingSpotCommand;
import com.smartparking.smartparking.application.service.OccupyParkingSpotService;
import com.smartparking.smartparking.domain.event.ParkingSpotFreedEvent;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotOccupiedListener {
    private static final Logger log = LoggerFactory.getLogger(ParkingSpotOccupiedListener.class);
    public static final String TOPIC = "smartbollard/+/occupied";
    private final AWSIotMqttClient client;
    private final ObjectMapper objectMapper;
    private final OccupyParkingSpotService service;

    public ParkingSpotOccupiedListener(AWSIotMqttClient client,
                                       ObjectMapper objectMapper,
                                       OccupyParkingSpotService service) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.service = service;
    }

    @PostConstruct
    public void init() throws AWSIotException {
        AWSIotTopic topic = new TopicHandler(TOPIC, AWSIotQos.QOS1);
        client.subscribe(topic);
        log.info("Subscribed to topic: {}", topic.getTopic());
    }

    class TopicHandler extends AWSIotTopic {

        public TopicHandler(String topic, AWSIotQos qos) {
            super(topic, qos);
        }

        @Override
        public void onMessage(AWSIotMessage message) {
            try {
                log.info("Message received: {}", message.getPayload());
                var event = objectMapper.readValue(message.getStringPayload(), ParkingSpotFreedEvent.class);
                service.execute(OccupyParkingSpotCommand.of(event));
            } catch (JsonProcessingException e) {
                log.warn("Error parsing JSON: {}", e.getMessage());
            }
        }
    }
}
