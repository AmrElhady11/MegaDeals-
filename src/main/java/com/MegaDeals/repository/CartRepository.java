package com.MegaDeals.repository;

import com.MegaDeals.entity.Cart;


public interface CartRepository {
    Cart getCartByCustomerID( int customerID);
    void createNewCart( int customerID);
//  @Query("SELECT c FROM Cart c WHERE c.status = 'ACTIVE' AND c.customerID.id = :id")
//  Cart getCartByCustomerID(@Param("id") Integer id);
//  @Transactional
//  @Modifying
//  @Query(value = "insert into Cart (status,creation_time,last_update_time,cutomer_id) values('ACTIVE',now(),now(),:customerID)",nativeQuery = true)
//  void createNewCart(@Param("customerID") int customerID);

}
