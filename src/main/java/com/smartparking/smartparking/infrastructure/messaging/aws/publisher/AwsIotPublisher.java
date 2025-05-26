package com.smartparking.smartparking.infrastructure.messaging.aws.publisher;

import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartparking.smartparking.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AwsIotPublisher {
    protected static Logger log = LoggerFactory.getLogger(AwsIotPublisher.class);
    private final AWSIotMqttClient awsIotClient;
    private final ObjectMapper objectMapper;

    public AwsIotPublisher(AWSIotMqttClient awsIotClient, ObjectMapper objectMapper) {
        this.awsIotClient = awsIotClient;
        this.objectMapper = objectMapper;
    }

    protected void publish(Event event, String topic) {
        try {
            var payload = objectMapper.writeValueAsBytes(event);
            awsIotClient.publish(new AWSIotMessage(topic, AWSIotQos.QOS1, payload));
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
    }
}
