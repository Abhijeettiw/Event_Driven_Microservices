package com.example.base.domain.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private Order order;
}
