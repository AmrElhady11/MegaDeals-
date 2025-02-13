package com.MegaDeals.service.impl;

import com.MegaDeals.entity.Order;
import com.MegaDeals.entity.Product;
import com.MegaDeals.model.OrderDto;
import com.MegaDeals.model.ProductDto;
import com.MegaDeals.repository.OrderRepository;
import com.MegaDeals.repository.ProductRepository;
import com.MegaDeals.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<OrderDto> getOrders(int customerID) {
        List<Order> orders = orderRepository.findByCustomerId(customerID);
        if (!orders.isEmpty()) {
            List<OrderDto> orderDtoList = new ArrayList<>();
            for (Order order : orders) {
                OrderDto orderDto = modelMapper.map(order, OrderDto.class);
                List<Product> productDtoList = productRepository.getAllProductsByOrderID(order.getId());
                for (Product product : productDtoList) {
                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
                    orderDto.getProducts().add(productDto);
                }
                orderDtoList.add(orderDto);
            }
            return orderDtoList;
        }
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
