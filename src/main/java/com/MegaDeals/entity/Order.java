package com.MegaDeals.entity;

import com.MegaDeals.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name="total_price")
    private double totalPrice;
    @Column(name="order_time")
    private LocalDateTime orderTime;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;
    @ManyToMany
    @JoinTable(
               name = "order_item",
               joinColumns ={ @JoinColumn(name = "order_id")},
               inverseJoinColumns ={@JoinColumn(name = "product_id")}
    )
    private Set<Product> products = new HashSet<>();
}