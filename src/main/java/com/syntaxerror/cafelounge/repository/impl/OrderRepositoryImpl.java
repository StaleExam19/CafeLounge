package com.syntaxerror.cafelounge.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.CustomerDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.mapper.OrderMapper;
import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.model.OrderItem;
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
        Map<Integer, Order> orderMap = new HashMap<>();

        for (int i = 0; i < orderDtos.size(); i++) {
            OrderDto orderDto = orderDtos.get(i);
            Order order = orderMap.get(orderDto.getOrderNum());

            if (order == null) {
                CustomerDto customer = customerRepository.getCustomerById(orderDto.getCustomerId());
                order = new Order();

                order.setCustomerName(customer.getFirstname() + " " + customer.getLastname());
                order.setOrderNumber(orderDto.getOrderNum());
                order.setStatus(orderDto.getStatus());
                order.setDateOrdered(orderDto.getDateOrdered());

                order.setOrders(new ArrayList<OrderItem>());

                orderMap.put(orderDto.getOrderNum(), order);
            }

            if (orderDto.getMenuId() != 0) {
                OrderItem orderItem = new OrderItem();
                MenuDto menu = menuRepository.getMenuById(orderDto.getMenuId());

                orderItem.setMenuName(menu.getName());
                orderItem.setQuantity(orderDto.getQuantity());
                orderItem.setPrice(menu.getPrice());

                order.getOrders().add(orderItem);
            }
        }

        return new ArrayList<>(orderMap.values());

    }

    @Override
    public Order getOrderByOrderNumber(int orderNumber) {
        String sql = "SELECT * FROM cafelounge_db.`order` WHERE order_number = ?";
        List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new Object[] { orderNumber }, new OrderMapper());
        Order order = null;

        for (int i = 0; i < orderDtos.size(); i++) {
            OrderDto orderDto = orderDtos.get(i);
            if (order == null) {
                CustomerDto customer = customerRepository.getCustomerById(orderDto.getCustomerId());
                order = new Order();

                order.setCustomerName(customer.getFirstname() + " " + customer.getLastname());
                order.setOrderNumber(orderDto.getOrderNum());
                order.setStatus(orderDto.getStatus());
                order.setDateOrdered(orderDto.getDateOrdered());

                order.setOrders(new ArrayList<OrderItem>());
            }

            if (orderDto.getMenuId() != 0) {
                OrderItem orderItem = new OrderItem();
                MenuDto menu = menuRepository.getMenuById(orderDto.getMenuId());

                orderItem.setMenuName(menu.getName());
                orderItem.setQuantity(orderDto.getQuantity());
                orderItem.setPrice(menu.getPrice());

                order.getOrders().add(orderItem);
            }
        }

        return order;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        String sql = "SELECT * FROM cafelounge_db.`order` WHERE status = ?";
        List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new Object[] { status }, new OrderMapper());
        Map<Integer, Order> orderMap = new HashMap<>();

        for (int i = 0; i < orderDtos.size(); i++) {
            OrderDto orderDto = orderDtos.get(i);
            Order order = orderMap.get(orderDto.getOrderNum());

            if (order == null) {
                CustomerDto customer = customerRepository.getCustomerById(orderDto.getCustomerId());
                order = new Order();

                order.setCustomerName(customer.getFirstname() + " " + customer.getLastname());
                order.setOrderNumber(orderDto.getOrderNum());
                order.setStatus(orderDto.getStatus());
                order.setDateOrdered(orderDto.getDateOrdered());

                order.setOrders(new ArrayList<OrderItem>());

                orderMap.put(orderDto.getOrderNum(), order);
            }

            if (orderDto.getMenuId() != 0) {
                OrderItem orderItem = new OrderItem();
                MenuDto menu = menuRepository.getMenuById(orderDto.getMenuId());

                orderItem.setMenuName(menu.getName());
                orderItem.setQuantity(orderDto.getQuantity());
                orderItem.setPrice(menu.getPrice());

                order.getOrders().add(orderItem);
            }
        }

        return new ArrayList<>(orderMap.values());

    }

    @Override
    public int countByStatus(String status) {
        return getOrdersByStatus(status).size();
    }

    @Override
    public void updateStatusByOrderNumber(int orderNumber, String status) {
        String sql = "UPDATE cafelounge_db.`order` SET status = ? ";

        if (status == "completed")
            sql += ", date_completed = CURRENT_TIMESTAMP ";

        sql += "WHERE order_number = ?";
        getJdbcTemplate().update(sql, status, orderNumber);

        // Update quantity
        List<OrderDto> orderDtos = getJdbcTemplate().query(
                "SELECT * FROM cafelounge_db.`order` WHERE order_number = ? AND status = ?",
                new Object[] { orderNumber, status },
                new OrderMapper());

        for (OrderDto order : orderDtos) {
            MenuDto menu = menuRepository.getMenuById(order.getMenuId());
            
            System.out.println(menu.getQuantity());
            menuRepository.updateQuantity(order.getMenuId(), order.getQuantity());
        }
    }

}
