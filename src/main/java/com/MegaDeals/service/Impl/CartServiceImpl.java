package com.MegaDeals.service.Impl;

import com.MegaDeals.entity.Cart;
import com.MegaDeals.entity.CartItem;
import com.MegaDeals.entity.Product;
import com.MegaDeals.model.CartItemDto;
import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.CartItemRepository;
import com.MegaDeals.repository.CartRepository;
import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository,ProductRepository productRepository, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void AddItemToCart(int customerID,int productID) {
        CartItem cartItem = createCartItem(productID);
        Cart cart = cartRepository.getCartByCustomerID(customerID);
        if(cart == null) {
             cartRepository.createNewCart(customerID);
            cart=cartRepository.getCartByCustomerID(customerID);
        }
        Product product = productRepository.findById(productID).get();
        cartItem.setCartID(cart);
        cartItemRepository.save(cartItem);

    }

    @Override
    public void RemoveItemFromCart(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public List<CartItemDto> getCartItems(int CustomerID) {
        Cart cart = cartRepository.getCartByCustomerID(CustomerID);
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cart.getId()).stream().toList();
        return List.of(modelMapper.map(cartItemList, CartItemDto.class));
    }


    private CartItem createCartItem(int productID) {
         Product theProduct= productRepository.findById(productID).get();
         CartItem cartItem = new CartItem();
         cartItem.setProductID(theProduct);
         cartItem.setQuantity(1);
        return cartItem;
    }
    private CartItemDto mapToCartItemDto(CartItem cartItem) {
        return modelMapper.map(cartItem, CartItemDto.class);
    }
    private CartItem mapToCartEntity(CartItemDto cartItem) {
        return modelMapper.map(cartItem, CartItem.class);
    }
}
