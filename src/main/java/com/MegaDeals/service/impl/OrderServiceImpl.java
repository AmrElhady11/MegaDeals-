package com.MegaDeals.service.impl;

import com.MegaDeals.model.OrderDto;
import com.MegaDeals.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderDto> getOrders() {
        return List.of();
    }

    @Override
    public OrderDto getOrderById(int id) {
        return null;
    }

    @Override
    public OrderDto addOrder(OrderDto order) {
        return null;
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
