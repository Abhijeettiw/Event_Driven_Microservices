package com.example.email.service.Kafka;

import com.example.base.domain.DTO.OrderEvent;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class EmailConsumer {

    private static final Logger log = LoggerFactory.getLogger(EmailConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){
        log.info(String.format("Message -> %s",event));
        JSONObject eventObject = new JSONObject(event);
        Object orderObject = eventObject.opt("order");
    }
}
