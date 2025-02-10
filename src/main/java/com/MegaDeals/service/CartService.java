package com.MegaDeals.service;

import com.MegaDeals.entity.Product;
import com.MegaDeals.model.CartItemDto;

import java.util.List;

public interface CartService {
    void AddItemToCart(int customerID,int productID);
    void RemoveItemFromCart( int cartItemId);
    List<CartItemDto> getCartItems(int customerID);

}
