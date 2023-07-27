package com.syntaxerror.cafelounge.repository;

import java.util.List;

import com.syntaxerror.cafelounge.model.Order;

public interface OrderRepository {

    int countByStatus(String status);

    void updateStatusByOrderNumber(int id, String status);

    List<Order> getAllOrders();

    Order getOrderByOrderNumber(int orderNumber);

    List<Order> getOrdersByStatus(String status);
}
