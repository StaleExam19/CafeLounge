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
        order.setQuantity(rs.getInt("quantity"));
        order.setStatus(rs.getString("status"));
        order.setOrderNum(rs.getInt("order_number"));
        order.setDateOrdered(rs.getDate("date_ordered"));
        order.setDateCompleted(rs.getDate("date_completed"));
        order.setDateDeleted(rs.getDate("date_deleted"));

        return order;
    }
    
}
