package com.MegaDeals.repository.Impl;

import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
   private EntityManager entityManager;
   @Autowired
   public ProductRepositoryImpl(EntityManager entityManager)
   {
       this.entityManager = entityManager;
   }
    @Override
    @Transactional
    public Product insert(ProductDetailsEntity productDetails) {
       Product product = new Product();
       product.setName(productDetails.getName());
       productDetails.setProductId(product);
       entityManager.persist(productDetails);
        return product;
    }

    @Override
    public Product findById(int id) {

        return entityManager.find(Product.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
       Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    @Transactional
    public void update(ProductDetailsEntity productDetails) {
        System.out.println("the id :" +productDetails.getId());
        Product product = findById(productDetails.getId());
        if (product != null) {
            product.setName(productDetails.getName());
            entityManager.merge(product);
        }
        productDetails.setProductId(product);
        entityManager.merge(productDetails);


    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> theQuery = entityManager.createQuery("from Product ", Product.class);

        return theQuery.getResultList();
    }

    @Override
    public ProductDetailsEntity findProductDetailsById(int id) {
        return entityManager.find(ProductDetailsEntity.class,id);

    }
}
