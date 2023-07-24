package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.OrderDto;

public class OrderMapper implements RowMapper<OrderDto> {

    @Override
    public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDto order = new OrderDto();

        order.setCustomerName(rs.getString("customer_name"));
        order.setMenuName(rs.getString("menu_name"));
        order.setQuantity(rs.getInt("quantity"));
        order.setStatus(rs.getString("status"));
        order.setDateOrdered(rs.getDate("date_ordered"));
        
        return order;
    }
    
}
