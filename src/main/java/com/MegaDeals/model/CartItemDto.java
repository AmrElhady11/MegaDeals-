package com.MegaDeals.model;

import com.MegaDeals.entity.Cart;
import com.MegaDeals.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    private Integer id;
    private int quantity;
    private Product productID;
    private Cart CartID;
    public double getTotalItemPrice(ProductDto product) {
        return product.getPrice() * quantity;
    }
}