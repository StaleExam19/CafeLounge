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
    public int countByStatus(String status) {
        return orderRepository.countByStatus(status);
    }

    @Override
    public void updateStatusByOrderNumber(int id, String status) {
        orderRepository.updateStatusByOrderNumber(id, status);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();        
    }

    @Override
    public Order getOrderByOrderNumber(int orderNumber) {
        return orderRepository.getOrderByOrderNumber(orderNumber);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.getOrdersByStatus(status);
    }
}
