package com.MegaDeals.service;

import com.MegaDeals.model.Product;
import com.MegaDeals.model.ProductDetails;

import java.util.List;


public interface ProductService {
 boolean addProduct(ProductDetails productDetails);
 List<Product> getAllProduct ();
 boolean updateProduct(ProductDetails productDetails);
 boolean deleteProduct(int id);
 ProductDetails getProductDetails(int id);

}
