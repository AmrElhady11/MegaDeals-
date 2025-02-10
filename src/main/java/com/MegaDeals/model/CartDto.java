package com.MegaDeals.model;

import com.MegaDeals.entity.Customer;
import com.MegaDeals.enums.CartStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Integer id;
    private CartStatus status;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
    private Customer customerID;
    public double getTotalPrice(List<CartItemDto> cartItem,ProductDto product) {
        double totalPrice = 0;
        for (CartItemDto cartItemDto : cartItem) {
            totalPrice+=cartItemDto.getTotalItemPrice(product);
        }
        return totalPrice;
    }

}