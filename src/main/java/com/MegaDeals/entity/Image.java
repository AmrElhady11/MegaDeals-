package com.MegaDeals.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String url;
    @Column(name = "file_name")
    private String fileName;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productID;
}
