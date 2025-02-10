package com.MegaDeals.repository;

import com.MegaDeals.entity.Cart;
import jakarta.transaction.Transactional;
import jdk.jfr.TransitionFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
  @Query("select c from Cart c where c.status='ACTIVE' and c.customerID=:id")
    Cart getCartByCustomerID(@Param("id") int id);
  @Transactional
  @Modifying
  @Query(value = "insert into Cart (status,creation_time,last_update_time,cutomer_id) values('ACTIVE',now(),now(),:customerID)",nativeQuery = true)
  void createNewCart(@Param("customerID") int customerID);



}
