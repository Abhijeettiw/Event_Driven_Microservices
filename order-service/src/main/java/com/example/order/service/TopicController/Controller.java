package com.example.order.service.TopicController;

import com.example.base.domain.DTO.Order;
import com.example.base.domain.DTO.OrderEvent;
import com.example.order.service.Kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order/")
public class Controller {
    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("produce")
    public ResponseEntity<?> orders(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setStatus("Pending");
        event.setMessage("Working on orders");
        event.setOrder(order);
        orderProducer.sendMessage(event);
        return new ResponseEntity<>(String.format("New Order -> %S", event), HttpStatus.CREATED);
    }
}
