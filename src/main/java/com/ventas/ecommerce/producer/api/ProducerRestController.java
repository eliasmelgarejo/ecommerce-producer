package com.ventas.ecommerce.producer.api;

import com.ventas.ecommerce.producer.model.EcommerceSales;
import com.ventas.ecommerce.producer.service.PublisherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/ecommerce/producer")
public class ProducerRestController {

    @Value(value = "${kafka.topic}")
    private String TOPIC;
    private final PublisherService publisher;

    public ProducerRestController(PublisherService publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody EcommerceSales message){
        try {
            log.info("Publicando mensaje al topic de kafka {} ", TOPIC);
            publisher.sendMessage(TOPIC, message);
            return ResponseEntity.ok("Mensaje publicado correctamente");

        }catch (Exception e ){
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

}
