package com.MegaDeals.repository;

import com.MegaDeals.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query(value = "select c from CartItem c where c.CartID.id =:cartId ")
    Optional<CartItem> findByCartId(@Param("cartId") int cartId);

}
