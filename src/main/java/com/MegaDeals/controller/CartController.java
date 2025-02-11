package com.MegaDeals.controller;

import com.MegaDeals.model.CartItemDto;
import com.MegaDeals.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartItemDto> cartItemsList = cartService.getCartItems(2);
        model.addAttribute("cartItemsList",cartItemsList);
        return "CartManagement/Cart";
    }
}
