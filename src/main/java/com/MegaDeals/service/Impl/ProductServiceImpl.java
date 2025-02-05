package com.MegaDeals.service.Impl;

import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.entity.Product;
import com.MegaDeals.model.ProductDetails;
import com.MegaDeals.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addProduct(ProductDetails productDetails) {

        try {
            productRepository.insert(mapToProductDetailsEntity(productDetails));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<com.MegaDeals.model.Product> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        if (productList == null || productList.isEmpty()) {
            return List.of();
        }
        return productList.stream().map(this::mapToProduct).toList();
    }

    @Override
    public boolean updateProduct(ProductDetails productDetails) {

        try {
            productRepository.update(mapToProductDetailsEntity(productDetails));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct == null) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public ProductDetails getProductDetails(int id) {
        ProductDetailsEntity theProduct = productRepository.findProductDetailsById(id);

        return mapToProductDetails(theProduct);
    }

    private ProductDetailsEntity mapToProductDetailsEntity(ProductDetails productDetails) {
        return modelMapper.map(productDetails, ProductDetailsEntity.class);
    }

    private com.MegaDeals.model.Product mapToProduct(Product productEntity) {
        return modelMapper.map(productEntity, com.MegaDeals.model.Product.class);
    }

    private ProductDetails mapToProductDetails(ProductDetailsEntity productDetailsEntity) {
        return modelMapper.map(productDetailsEntity, ProductDetails.class);
    }
}
