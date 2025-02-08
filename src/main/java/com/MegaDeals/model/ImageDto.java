package com.MegaDeals.model;

import com.MegaDeals.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private int id;
    private String url;
    private String fileName;
    private Product productID;
}
