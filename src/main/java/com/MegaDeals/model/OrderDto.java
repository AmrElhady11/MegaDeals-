package com.MegaDeals.model;

import com.MegaDeals.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;
    private OrderStatus status;
    private double totalPrice;
    private LocalDateTime orderTime;
    private Integer customerID;
    private Set<ProductDto> products;
}
