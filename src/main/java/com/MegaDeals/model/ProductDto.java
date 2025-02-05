package com.MegaDeals.model;

import com.MegaDeals.entity.Admin;
import com.MegaDeals.entity.Seller;
import com.MegaDeals.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private String manufacturer;
    private LocalDate productionDate;
    private LocalDate expirationDate;
    private Double price;
    private int stockQuantity;
    private Boolean availability;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
    private Seller sellerID;
    private Status status;
    private Admin approvedBy;
}
