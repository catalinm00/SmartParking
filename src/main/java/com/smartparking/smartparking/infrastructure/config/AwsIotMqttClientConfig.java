package com.smartparking.smartparking.infrastructure.config;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class AwsIotMqttClientConfig {
    private final static Logger log = LoggerFactory.getLogger(AwsIotMqttClientConfig.class);

    @Value("${aws.iot.endpoint}")
    private String endpoint;

    @Bean
    public AWSIotMqttClient awsIotClient() throws AWSIotException {
        String clientId = "IoTDeviceClient-" + UUID.randomUUID();
        String certificateFile = "src/main/resources/aws/certificate.pem.crt";
        String privateKeyFile = "src/main/resources/aws/private.pem.key";

        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        var client = new AWSIotMqttClient(endpoint, clientId, pair.keyStore, pair.keyPassword);
        log.info("AWS Iot client created");
        client.connect();
        return client;
    }
}

