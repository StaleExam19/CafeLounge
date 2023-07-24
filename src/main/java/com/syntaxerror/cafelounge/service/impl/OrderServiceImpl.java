package com.syntaxerror.cafelounge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.repository.OrderRepository;
import com.syntaxerror.cafelounge.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(int customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }

}
