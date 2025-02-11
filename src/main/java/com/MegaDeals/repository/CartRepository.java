package com.MegaDeals.repository;

import com.MegaDeals.entity.Cart;
import jakarta.transaction.Transactional;
import jdk.jfr.TransitionFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  {
    Cart getCartByCustomerID( int customerID);
    void createNewCart( int customerID);
//  @Query("SELECT c FROM Cart c WHERE c.status = 'ACTIVE' AND c.customerID.id = :id")
//  List<Cart> getCartByCustomerID(@Param("id") Integer id);
//  @Transactional
//  @Modifying
//  @Query(value = "insert into Cart (status,creation_time,last_update_time,cutomer_id) values('ACTIVE',now(),now(),:customerID)",nativeQuery = true)
//  void createNewCart(@Param("customerID") int customerID);



}
