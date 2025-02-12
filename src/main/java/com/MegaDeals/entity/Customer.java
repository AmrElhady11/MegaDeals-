package com.MegaDeals.entity;

import com.MegaDeals.secuirty.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private int total_orders;
    private int total_delivered_orders;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User userId;
}