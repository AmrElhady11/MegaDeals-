package com.MegaDeals.service.Impl;

import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.entity.Product;
import com.MegaDeals.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addProduct(ProductDto product) {

        try {
            productRepository.save(mapToProductEntity(product));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        if (productList == null || productList.isEmpty()) {
            return List.of();
        }
        return productList.stream().map(this::mapToProductDto).toList();
    }


    @Override
    public boolean updateProduct(ProductDto product) {

        try {
            Optional<Product> optionalProduct = productRepository.findById(product.getId());

            Product theProduct = optionalProduct.orElse(null);
            if (theProduct != null) {
                productRepository.save(theProduct);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProductDto getProductById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return mapToProductDto(productOptional.get());
        }
        return null;
    }


    private ProductDto mapToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
    private Product mapToProductEntity(ProductDto product) {
        return modelMapper.map(product, Product.class);
    }

}
