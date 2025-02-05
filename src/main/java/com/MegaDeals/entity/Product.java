package com.MegaDeals.entity;

import com.MegaDeals.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String manufacturer;
    @Column(name = "production_date")
    private LocalDate productionDate;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "unit_price")
    private Double price;
    @Column(name = "stock_quantity")
    private int stockQuantity;
    private Boolean availability;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdateTime;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Admin admin;


}
