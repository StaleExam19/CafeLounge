package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.MenuApiDto;
public class MenuApiMapper implements RowMapper<MenuApiDto> {

    @Override
    public MenuApiDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuApiDto menuDto = new MenuApiDto();

        menuDto.setId(rs.getInt("id"));
        menuDto.setName(rs.getString("name"));
        menuDto.setCategory(rs.getString("category"));
        menuDto.setDescription(rs.getString("description"));
        menuDto.setQuantity(rs.getInt("quantity"));
        menuDto.setStatus(rs.getString("status"));

        return menuDto;
    }

}
