package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto user = new UserDto();
		
		user.setId(rs.getInt("chef_id"));
		user.setUsername(rs.getString("chef_username"));
		user.setPassword(rs.getString("chef_password"));
		user.setDateUpdated(rs.getDate("date_updated"));
		
		return user;
	}

}
