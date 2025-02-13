package com.MegaDeals.controller;

import com.MegaDeals.model.OrderDto;
import com.MegaDeals.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/order")
    public List<OrderDto> getAllOrders() {
        return orderService.getOrders(1);
    }
}
