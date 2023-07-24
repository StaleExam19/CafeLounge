package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.OrderDto;

public class OrderMapper implements RowMapper<OrderDto> {

    @Override
    public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDto order = new OrderDto();

        order.setId(rs.getInt("id"));
        order.setCustomerId(rs.getInt("customer_id"));
        order.setMenuId(rs.getInt("menu_id"));
        order.setDate_ordered(rs.getDate("date_ordered"));
        order.setDate_completed(rs.getDate("date_completed"));
        order.setDate_deleted(rs.getDate("date_deleted"));

        return order;
    }
    
}
