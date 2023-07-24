package com.syntaxerror.cafelounge.service;

import java.util.List;

import com.syntaxerror.cafelounge.dto.OrderDto;

public interface OrderService {
    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByCustomerId(int customerId);

}
