package com.example.order.service.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Topic {

    @Value("${spring.kafka.topic.name}")
    private String topic;

    public NewTopic topic(){
        return TopicBuilder
                .name(topic)
                .partitions(5)
                .build();
    }
}
