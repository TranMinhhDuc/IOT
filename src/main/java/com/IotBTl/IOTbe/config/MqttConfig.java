package com.IotBTl.IOTbe.config;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttConfig {

    private String broker = "tcp://192.168.1.10:1885";
    private String clientId = "web";
    private IMqttClient client;

    public MqttConfig() {
        try {
            client = new MqttClient(broker, clientId);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName("client");
            options.setPassword("00000".toCharArray());

            // Connect to the broker
            client.connect(options);

        } catch (MqttException e) {
            System.out.println("Error during MQTT connection or subscription");
            e.printStackTrace();
        }
    }

    public void subscribeToTopic(String topic) throws MqttException {
        client.subscribe(topic, new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(new String(message.getPayload()));
            }
        });
    }
}

