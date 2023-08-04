package com.syntaxerror.cafelounge.service;

import java.util.List;

import com.syntaxerror.cafelounge.model.Order;

public interface OrderService {

        int countByStatus(String status);

        void updateStatusByOrderNumber(int id, String status);

        List<Order> getAllOrders();

        Order getOrderByOrderNumber(int orderNumber);

        List<Order> getOrdersByStatus(String status);

        List<Order> paginateOrder(int pageNumber);

        List<Order> paginateOrderWithStatus(int pageNumber, String status);
}
