package com.MegaDeals.service.impl;

import com.MegaDeals.model.OrderDto;
import com.MegaDeals.repository.OrderRepository;
import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

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
