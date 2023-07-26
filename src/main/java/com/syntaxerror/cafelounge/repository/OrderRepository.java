package com.syntaxerror.cafelounge.repository;

import java.util.List;

import com.syntaxerror.cafelounge.model.Order;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    int countByStatus(String status);
    void updateStatusById(int id, String status);
    List<Order> getOrdersByStatus(String status);
}
