package com.example.stock.service.Kafka;

import com.example.base.domain.DTO.OrderEvent;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    private static final Logger log = LoggerFactory.getLogger(StockConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrderMessage(OrderEvent event){log.info(String.format("Order -> %s",event.toString()));
        JSONObject object = new JSONObject(event);
        Object orderJson = object.opt("order");

    }
}
