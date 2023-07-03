package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.MenuDto;

public class MenuMapper implements RowMapper<MenuDto> {

    @Override
    public MenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuDto menu = new MenuDto();

        menu.setId(rs.getInt("menu_id"));
        menu.setName(rs.getString("menu_name"));
        menu.setPrice(rs.getDouble("menu_price"));
        menu.setCategory(rs.getString("menu_category"));
        menu.setImage(rs.getBytes("menu_image"));

        return menu;
    }

}
