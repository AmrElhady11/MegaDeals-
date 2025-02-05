package com.MegaDeals.service;

import com.MegaDeals.model.ProductDto;

import java.util.List;


public interface ProductService {
      boolean addProduct(ProductDto product);
      List<ProductDto> getAllProduct ();
      boolean updateProduct(ProductDto productDetails);
      boolean deleteProduct(int id);
      ProductDto getProductById(int id);

}
