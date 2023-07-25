package com.syntaxerror.cafelounge.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.mapper.OrderMapper;
import com.syntaxerror.cafelounge.model.Customer;
import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.repository.CustomerRepository;
import com.syntaxerror.cafelounge.repository.MenuRepository;
import com.syntaxerror.cafelounge.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl implements OrderRepository {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM cafelounge_db.`order` WHERE 1";
        List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new OrderMapper());
        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < orderDtos.size(); i++) {
            OrderDto orderDto = orderDtos.get(i);
            Customer customer = customerRepository.getCustomerById(orderDto.getCustomerId());
            MenuDto menuDto = menuRepository.findById(orderDto.getMenuId());
            Order order = new Order();

            order.setId(orderDto.getId());
            order.setCustomerName(customer.getFirstname() + " " + customer.getLastname());
            order.setDateOrdered(orderDto.getDateOrdered());
            order.setPaymentMethod("Cash");
            order.setStatus(orderDto.getStatus());

            order.setMenuName(menuDto.getName());
            order.setMenuPrice(menuDto.getPrice());
            order.setQuantity(orderDto.getQuantity());

            orders.add(order);
        }

        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        Order order = new Order();

        String sql = "SELECT * FROM cafelounge_db.`order` WHERE id = ?";
        OrderDto orderDto = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new OrderMapper());
        Customer customer = customerRepository.getCustomerById(orderDto.getCustomerId());
        MenuDto menuDto = menuRepository.findById(orderDto.getMenuId());

        order.setId(orderDto.getId());
        order.setCustomerName(customer.getFirstname() + " " + customer.getLastname());
        order.setDateOrdered(orderDto.getDateOrdered());
        order.setPaymentMethod("Cash");
        order.setStatus(orderDto.getStatus());

        order.setMenuName(menuDto.getName());
        order.setMenuPrice(menuDto.getPrice());
        order.setQuantity(orderDto.getQuantity());

        return order;
    }

}
