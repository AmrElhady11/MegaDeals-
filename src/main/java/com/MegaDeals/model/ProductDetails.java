package com.MegaDeals.model;

import com.MegaDeals.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    private Integer id;
    private Product productId;
    private String name;
    private LocalDate expirationDate;
    private String manufacturer;
    private Double price;
    private Boolean available ;
}
