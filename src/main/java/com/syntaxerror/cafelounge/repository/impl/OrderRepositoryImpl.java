package com.syntaxerror.cafelounge.repository.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.mapper.OrderMapper;
import com.syntaxerror.cafelounge.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl implements OrderRepository {

    @Override
    public List<OrderDto> getAllOrders() {
        String sql = "SELECT CONCAT(customer.firstname, \" \", customer.lastname)\n" + //
                "AS customer_name, menu.name AS menu_name, `order`.quantity, date_ordered, `order`.status\n" + //
                "FROM `order`\n" + //
                "INNER JOIN customer ON `order`.`customer_id` = customer_id\n" + //
                "INNER JOIN menu  ON `order`.`menu_id` = menu.id";
        try {
            return getJdbcTemplate().query(sql, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null or any other value to indicate no matching rows
        }
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(int customerId) {
        String sql = "SELECT CONCAT(customer.firstname, \" \", customer.lastname)\n" + //
                "AS customer_name, menu.name AS menu_name, `order`.quantity, date_ordered, `order`.status\n" + //
                "FROM `order`\n" + //
                "INNER JOIN customer ON `order`.`customer_id` = customer_id\n" + //
                "INNER JOIN menu  ON `order`.`menu_id` = menu.id\n" + //
                "WHERE customer.id = ?;";
        try {
            return getJdbcTemplate().query(sql, new Object[] {customerId}, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null or any other value to indicate no matching rows
        }
    }

}
