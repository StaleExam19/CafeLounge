package com.syntaxerror.cafelounge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.repository.OrderRepository;
import com.syntaxerror.cafelounge.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public int countByStatus(String status) {
        return orderRepository.countByStatus(status);
    }

    @Override
    public void updateStatusById(int id, String status) {
        orderRepository.updateStatusById(id, status);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.getOrdersByStatus(status);
    }
    
}
