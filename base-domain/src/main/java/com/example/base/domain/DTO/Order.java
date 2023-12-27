package com.example.base.domain.DTO;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Order {
    private Long id;
    private String orderId;
    private String orderName;
    private Double orderPrice;
}
