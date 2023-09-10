package com.ventas.ecommerce.producer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Value(value = "${kafka.topic}")
    private String TOPIC;
    @Value(value = "${kafka.num-partitions}")
    private int NUM_PARTITIONS;
    @Value(value = "${kafka.replication-factor}")
    private Short REPLICATION_FACTOR;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    //si no tienes ningún topic creado
    //este bean verá si ya hay un topic creado, si no, lo creará
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic(TOPIC, NUM_PARTITIONS,  REPLICATION_FACTOR);
    }
}
