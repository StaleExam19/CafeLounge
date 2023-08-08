package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.ChefDto;

public class ChefMapper implements RowMapper<ChefDto> {

	@Override
	public ChefDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChefDto user = new ChefDto();

		user.setId(rs.getInt("id"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setDateCreated(rs.getDate("date_created"));
		user.setDateUpdated(rs.getDate("date_updated"));
		user.setDateDeleted(rs.getDate("date_deleted"));

		return user;
	}

}
