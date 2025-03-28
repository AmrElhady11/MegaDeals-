package com.MegaDeals.controller;

import com.MegaDeals.enums.OrderStatus;
import com.MegaDeals.model.OrderDto;
import com.MegaDeals.model.ProductDto;
import com.MegaDeals.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/order/confirmOrder")
    public String getAllOrderItems(@ModelAttribute("cartItems") List<ProductDto> orderItems) {
        return "order/confirmOrder";


    }
    @GetMapping("/order")
    String confirmOrder(@ModelAttribute("cartItems") List<ProductDto> orderItems) {
        OrderDto orderDto = new OrderDto();
        for(ProductDto productDto : orderItems) {
            orderDto.getProducts().add(productDto);
        }
        orderDto.setOrderTime(LocalDateTime.now());
        orderDto.setStatus(OrderStatus.SHIPPING);
        orderDto.setCustomerID(2);
        orderDto.setTotalPrice(ProductDto.getTotalPrice(orderItems));
        orderService.addOrder(orderDto);
        return "order/confirmOrder";
    }
}
