package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.CustomerDto;

public class CustomerMapper implements RowMapper<CustomerDto> {

    @Override
    public CustomerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerDto customer = new CustomerDto();

        customer.setId(rs.getInt("id"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));

        return customer;
    }

}
