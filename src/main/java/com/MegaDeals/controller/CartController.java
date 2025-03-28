package com.MegaDeals.controller;

import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.SellerRepository;
import com.MegaDeals.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
public class CartController {
    private final ProductService productService;
    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/cart")
    public String viewCartPage(Model model, HttpSession session) {
        HashSet<Integer> cartItemsList = (HashSet<Integer>) session.getAttribute("cartItemsList");
        List<ProductDto> cartItems = new ArrayList<>();
        if (!cartItemsList.isEmpty() && cartItemsList.size() != 0) {
            for (Integer i : cartItemsList) {
                cartItems.add(productService.getProductById(i));
            }
            model.addAttribute("cartItems", cartItems);
            Integer quantity = 1;
            model.addAttribute("quantity", quantity);
        }
        return "CartManagement/Cart";

    }



    @PostMapping("/home/addToCart/{itemId}")
    @ResponseBody
    public ResponseEntity<?> addToCart(@PathVariable int itemId, HttpSession session) {

        HashSet<Integer> cartItemsList = (HashSet<Integer>) session.getAttribute("cartItemsList");
        if(cartItemsList == null){
            cartItemsList = new LinkedHashSet<>();
        }

        cartItemsList.add(itemId);
        session.setAttribute("cartItemsList",cartItemsList);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable int id, HttpSession session) {
        HashSet<Integer> cartItemsList = (HashSet<Integer>) session.getAttribute("cartItemsList");
        cartItemsList.remove(id);
        session.setAttribute("cartItemsList",cartItemsList);
        return "redirect:/cart";
    }
    @PostMapping("/cart/update/{id}/{quantity}")
    public String updateCart(@PathVariable int id, @ModelAttribute("cartItems") List<ProductDto> theCartItems, @PathVariable int quantity, Model model) {
        ProductDto product = productService.getProductById(id);
        System.out.println("Iam HERE ===================================================");

        theCartItems.remove(product);
        product.setDemandQuantity(quantity);
        theCartItems.add(product);

        model.addAttribute("cartItems",theCartItems);
        return "redirect:/cart";
    }

}
