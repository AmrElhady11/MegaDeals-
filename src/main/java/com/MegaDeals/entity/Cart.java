package com.MegaDeals.entity;

import com.MegaDeals.enums.CartStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private CartStatus status;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;

}