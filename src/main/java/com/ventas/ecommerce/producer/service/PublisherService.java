package com.ventas.ecommerce.producer.service;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.ventas.ecommerce.producer.model.EcommerceSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private KafkaTemplate<String, EcommerceSales> kafkaTemplate;

    public void sendMessage(String topicName, EcommerceSales msg) {
        kafkaTemplate.send(topicName, msg);
    }
}
