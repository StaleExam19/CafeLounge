package com.syntaxerror.cafelounge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntaxerror.cafelounge.dto.MenuDto;

public class MenuMapper implements RowMapper<MenuDto> {

    @Override
    public MenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuDto menu = new MenuDto();

        menu.setId(rs.getInt("id"));
        menu.setName(rs.getString("name"));
        menu.setDescription(rs.getString("description"));
        menu.setPrice(rs.getDouble("price"));
        menu.setStatus(rs.getString("status"));
        menu.setCategory(rs.getString("category"));
        menu.setQuantity(rs.getInt("quantity"));
        menu.setImage(rs.getBytes("image"));
        menu.setAddedBy(rs.getString("added_by"));
        menu.setUpdatedBy(rs.getString("updated_by"));
        menu.setDateCreated(rs.getDate("date_created"));
        menu.setDateUpdated(rs.getDate("date_updated"));
        menu.setDateDeleted(rs.getDate("date_deleted"));

        return menu;
    }

}
