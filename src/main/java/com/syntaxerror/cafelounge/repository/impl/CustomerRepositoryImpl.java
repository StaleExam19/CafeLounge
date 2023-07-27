package com.syntaxerror.cafelounge.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.CustomerDto;
import com.syntaxerror.cafelounge.mapper.CustomerMapper;
import com.syntaxerror.cafelounge.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl implements CustomerRepository {

    @Override
    public CustomerDto getCustomerById(int id) {
        String sql = "SELECT * FROM cafelounge_db.customer WHERE id = ?";
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new CustomerMapper());
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

}
