package com.MegaDeals.service.Impl;

import ch.qos.logback.core.util.StringUtil;
import com.MegaDeals.entity.Image;
import com.MegaDeals.enums.Status;
import com.MegaDeals.model.ImageDto;
import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.ImageRepository;
import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.entity.Product;
import com.MegaDeals.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private ImageRepository imageRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper,ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.imageRepository = imageRepository;
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
    public Page<ProductDto> getAllProduct(int pageNo) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(pageNo-1,5,sort);
        Page<Product> productList = productRepository.findAll(pageable);

        return productList.map(this::mapToProductDto);
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

    @Override
    public void SaveProduct(ProductDto product, MultipartFile file) {
       Product theProduct= productRepository.save(mapToProductEntity(product));
       Image image = new Image();
       image.setProductID(theProduct);
       image.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
       try {
           image.setUrl(Base64.getUrlEncoder().encodeToString(file.getBytes()));
       }
       catch (Exception e) {
           e.printStackTrace();
       }

    }


    private ProductDto mapToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
    private Product mapToProductEntity(ProductDto product) {
        return modelMapper.map(product, Product.class);
    }
    private ImageDto mapToImageDto(Image image) {
        return modelMapper.map(image, ImageDto.class);
    }
    private Image mapToImageEntity(ImageDto image) {
        return modelMapper.map(image, Image.class);
    }

}
