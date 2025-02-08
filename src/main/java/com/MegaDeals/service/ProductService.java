package com.MegaDeals.service;

import com.MegaDeals.model.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {
      boolean addProduct(ProductDto product);
      Page<ProductDto> getAllProduct (int pageNo);
      boolean updateProduct(ProductDto productDetails);
      boolean deleteProduct(int id);
      ProductDto getProductById(int id);
      public void SaveProduct(ProductDto product, MultipartFile file);

}
