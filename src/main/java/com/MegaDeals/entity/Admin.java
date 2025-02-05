package com.MegaDeals.entity;

import com.MegaDeals.enums.Permission;
import com.MegaDeals.secuirty.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Permission permissions ;
    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userID;

}
