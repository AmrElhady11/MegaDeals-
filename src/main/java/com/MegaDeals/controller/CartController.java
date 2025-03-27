package com.MegaDeals.controller;

import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.SellerRepository;
import com.MegaDeals.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.LinkedHashSet;

@Controller
public class CartController {
    private final ProductService productService;
    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/home/addToCart/{itemId}")
    @ResponseBody
    public ResponseEntity<?> addToCart(@PathVariable int itemId, HttpSession session) {
        ProductDto product = productService.getProductById(itemId);
        HashSet<ProductDto> cartItemsList = (HashSet<ProductDto>) session.getAttribute("cartItemsList");
        if(cartItemsList == null){
            cartItemsList = new LinkedHashSet<>();
        }

        cartItemsList.add(product);
        session.setAttribute("cartItemsList",cartItemsList);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable int id, HttpSession session) {
        ProductDto product = productService.getProductById(id);
        HashSet<ProductDto> cartItemsList = (HashSet<ProductDto>) session.getAttribute("cartItemsList");

        cartItemsList.remove(product);
        session.setAttribute("cartItemsList",cartItemsList);
        return "redirect:/cart";
    }
    @PostMapping("/cart/update/{id}/{quantity}")
    public String updateCart(@PathVariable int id,@PathVariable int quantity, HttpSession session) {
        ProductDto product = productService.getProductById(id);
        HashSet<ProductDto> cartItemsList = (HashSet<ProductDto>) session.getAttribute("cartItemsList");
        cartItemsList.remove(product);
        product.setDemandQuantity(quantity);
        cartItemsList.add(product);

        session.setAttribute("cartItemsList",cartItemsList);
        return "redirect:/cart";
    }

}
