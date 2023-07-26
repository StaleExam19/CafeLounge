package com.syntaxerror.cafelounge.service;

import java.util.List;

import com.syntaxerror.cafelounge.model.Order;

public interface OrderService {
        List<Order> getAllOrders();

        Order getOrderById(int id);

        int countByStatus(String status);

        void updateStatusById(int id, String status);
        List<Order> getOrdersByStatus(String status);

}
