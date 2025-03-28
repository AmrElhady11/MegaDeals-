package com.MegaDeals.repository;

import com.MegaDeals.entity.Product;
import com.MegaDeals.model.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.status ='APPROVED'")
    Page<Product> findAll(Pageable pageable);
    @Query("select p from Product p where p.status ='APPROVED' and p.name like :name")
    Page<Product> findByName(String name, Pageable pageable);

    @Query("select p from Product p inner join OrderItem o on p.id = o.productID and o.orderID=:orderID")
    List<Product> getAllProductsByOrderID(@Param("orderID") int orderID);
}
