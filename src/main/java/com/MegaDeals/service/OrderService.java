package com.MegaDeals.service;

import com.MegaDeals.model.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders(int customerID);
    OrderDto getOrderById(int id);
    OrderDto addOrder(OrderDto order);
    OrderDto updateOrder(OrderDto order);
    void deleteOrder(int id);
}
