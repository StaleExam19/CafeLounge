package com.syntaxerror.cafelounge.repository;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.mapper.ChefMapper;

@Repository
public class ChefRepository extends NamedParameterJdbcDaoSupport {
	@Autowired
	protected DataSource dataSource;
	
	@PostConstruct
	private void init() {
		super.setDataSource(dataSource);
	}
	
	
	public ChefDto findUserByUsername(String username) {
		String sql = "SELECT * FROM cafelounge_db.chef WHERE username = ?";
		
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {username}, new ChefMapper());
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void updateProfile(ChefDto user) {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE cafelounge_db.chef SET ")
		    .append("username = ?, password = ?, date_updated = date_format(NOW(), '%Y/%c/%e %T') ")
		    .append("WHERE id = ?");

	
		getJdbcTemplate().update(sql.toString(),
				user.getUsername(),
				user.getPassword(),
				user.getId());
	}
	
}
