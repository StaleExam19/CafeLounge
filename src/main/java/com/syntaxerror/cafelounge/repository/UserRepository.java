package com.syntaxerror.cafelounge.repository;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.mapper.UserMapper;
import com.syntaxerror.cafelounge.model.UserForm;

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

	public void updateProfile(int id, UserForm user) {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE cafelounge_db.chefs SET ")
		    .append("chef_firstname = ?, chef_lastname = ?, chef_username = ?, chef_password =?, date_updated = date_format(NOW(), '%Y/%c/%e %T') ")
		    .append("WHERE chef_id = ?");

	
		getJdbcTemplate().update(sql.toString(),
				user.getFirstname(),
				user.getLastname(),
				user.getUsername(),
				user.getPassword(),
				id);
		System.out.println("Ok update");
	}
	
}
