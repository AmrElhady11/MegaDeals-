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
    private String description;
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
    @Lob
    @Column(columnDefinition = "BLOB")
    private String image;
    @Column(name = "image_name")
    private String imageName;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller sellerID;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Admin approvedBy;


}
