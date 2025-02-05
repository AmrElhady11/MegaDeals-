package com.MegaDeals.repository;

import com.MegaDeals.entity.Product;

import java.util.List;

public interface ProductRepository  {

    Product insert(ProductDetailsEntity productDetails);
    Product findById(int id);
    void deleteById(int id);
    void update(ProductDetailsEntity productDetails);
    List<Product> findAll();
    ProductDetailsEntity findProductDetailsById(int id);
}
