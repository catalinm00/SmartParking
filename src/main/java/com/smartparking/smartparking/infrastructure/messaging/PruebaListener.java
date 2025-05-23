package com.smartparking.smartparking.infrastructure.messaging;

import com.amazonaws.services.iot.client.*;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PruebaListener {
    private static final Logger log = LoggerFactory.getLogger(PruebaListener.class);
    public static final String TOPIC = "parking/prueba";
    private final AWSIotMqttClient client;

    public PruebaListener(AWSIotMqttClient client) {
        this.client = client;
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
            System.out.println(message.getStringPayload());
            log.info(message.getStringPayload());
        }
    }
}
