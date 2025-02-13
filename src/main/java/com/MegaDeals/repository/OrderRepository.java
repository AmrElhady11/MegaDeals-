package com.MegaDeals.repository;

import com.MegaDeals.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.customerID.id = :customerID")
    List<Order> findByCustomerId(@Param("customerID") int customerId);
}
