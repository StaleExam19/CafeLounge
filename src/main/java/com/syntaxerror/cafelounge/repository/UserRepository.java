package com.syntaxerror.cafelounge.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.mapper.UserMapper;

@Repository
public class UserRepository extends NamedParameterJdbcDaoSupport {
	@Autowired
	protected DataSource dataSource;
	
	@PostConstruct
	private void init() {
			super.setDataSource(dataSource);
	}
	
	
	public UserDto findUserByUsername(String username) {
		String sql = "SELECT * FROM cafelounge_db.chefs WHERE chef_username = ?";
		
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {username}, new UserMapper());
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
