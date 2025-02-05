package com.MegaDeals.entity;

import com.MegaDeals.secuirty.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sellers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String rating;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userID;
}
