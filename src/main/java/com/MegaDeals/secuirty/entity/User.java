package com.MegaDeals.secuirty.entity;

import com.MegaDeals.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role ;
    @Column(name = "creation_time")
    private  LocalDateTime creationTime;
    @Column(name = "last_updated_time")
    private LocalDateTime lastUpdateTime;

}