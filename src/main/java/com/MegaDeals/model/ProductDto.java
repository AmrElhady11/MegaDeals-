package com.MegaDeals.model;

import com.MegaDeals.entity.Admin;
import com.MegaDeals.entity.Seller;
import com.MegaDeals.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private String manufacturer;
    private LocalDate productionDate;
    private LocalDate expirationDate;
    private Double price;
    private int stockQuantity;
    private Boolean availability;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
    private Seller sellerID;
    private Status status;
    private Admin approvedBy;
    private double rating;
    private String image;
    private String imageName;
    private int demandQuantity=1 ;

    public  static int  getTotalPrice(List<ProductDto> products) {
        if(products==null || products.isEmpty())
            return 0;
        int totalPrice = 0;
        for (ProductDto product : products) {
            totalPrice += (product.getPrice()*product.getDemandQuantity());
        }
        return totalPrice;
    }
}
