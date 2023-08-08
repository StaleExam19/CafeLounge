package com.syntaxerror.cafelounge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.repository.OrderRepository;
import com.syntaxerror.cafelounge.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private int limit = 10;

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

    @Override
    public List<Order> paginateOrder(int pageNumber) {
        List<Order> orders = orderRepository.getAllOrders();

        int start = (limit * pageNumber) - limit;
        int end = limit * pageNumber;

        start = start > orders.size() ? 0 : start;
        end = end > orders.size() ? orders.size() : end;

        return orders.subList(start, end);
    }

    @Override
    public List<Order> paginateOrderWithStatus(int pageNumber, String status) {
        List<Order> orders = orderRepository.getOrdersByStatus(status);

        int start = (limit * pageNumber) - limit;
        int end = limit * pageNumber;
        
        start = start > orders.size() ? 0 : start;
        end = end > orders.size() ? orders.size() : end;

        return orders.subList(start, end);
    }

    @Override
    public int countPage() {
        int orders = orderRepository.getAllOrders().size();
        int count = (orders / limit);
        int remainder = orders % limit;
        
        return remainder == 0 ? count : count + 1;
    }

    @Override
    public int countOrderWithStatus(String status) {
        int orders = orderRepository.getOrdersByStatus(status).size();
        int count = (orders / limit);
        int remainder = orders % limit;
        
        return remainder == 0 ? count : count + 1;
    }
}
