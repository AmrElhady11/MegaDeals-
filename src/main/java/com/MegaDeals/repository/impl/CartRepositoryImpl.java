package com.MegaDeals.repository.impl;

import com.MegaDeals.entity.Cart;
import com.MegaDeals.entity.Customer;
import com.MegaDeals.enums.CartStatus;
import com.MegaDeals.repository.CartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private EntityManager em;
    public CartRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cart getCartByCustomerID(int customerID) {
        TypedQuery<Cart> theQuery = em.createQuery("FROM Cart c WHERE c.status = 'ACTIVE' AND c.customerID.id = :id", Cart.class);
        theQuery.setParameter("id", customerID);
        return theQuery.getSingleResult();
    }
    @Transactional
    @Override
    public void createNewCart(int customerID) {
        Customer theCustomer = em.find(Customer.class, customerID);
        Cart newCart = new Cart();
        newCart.setCustomerID(theCustomer);
        newCart.setStatus(CartStatus.ACTIVE);
        newCart.setCreationTime(LocalDateTime.now());
        newCart.setLastUpdateTime(LocalDateTime.now());
        em.persist(newCart);
    }
}
