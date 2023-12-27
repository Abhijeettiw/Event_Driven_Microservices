package com.example.order.service.Kafka;

import com.example.base.domain.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topic;

    private KafkaTemplate<String, OrderEvent> template;


    public OrderProducer(KafkaTemplate<String, OrderEvent> template) {
        this.template = template;
    }

    //    private Topic topic;



    public void sendMessage(OrderEvent orderEvent){
        log.info(String.format("Order Event -> %s",orderEvent));
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC,topic)
                .build();
        template.send(message);
    }
}
