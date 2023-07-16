package com.syntaxerror.cafelounge.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.mapper.ChefMapper;
import com.syntaxerror.cafelounge.repository.ChefRepository;

@Repository
public class ChefRepositoryImpl extends BaseRepositoryImpl implements ChefRepository {
	
	@Override
	public ChefDto findByUsername(String username) {
		String sql = "SELECT * FROM cafelounge_db.chef WHERE username = ?";
		
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {username}, new ChefMapper());
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
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
