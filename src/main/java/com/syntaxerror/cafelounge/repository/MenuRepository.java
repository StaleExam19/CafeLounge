package com.syntaxerror.cafelounge.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.mapper.MenuMapper;

@Repository
public class MenuRepository extends NamedParameterJdbcDaoSupport{
    @Autowired
    protected DataSource dataSource;

    @PostConstruct
    private void init() {
        super.setDataSource(dataSource);
    }


	public List<MenuDto> getAllMenu() {
		String sql = "SELECT * FROM cafelounge_db.menu WHERE 1";
		try {
		    return getJdbcTemplate().query(sql, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
		    return null; // Return null or any other value to indicate no matching rows
		}
	}

    public MenuDto findById(int id) {
        String sql = "SELECT * FROM cafelounge_db.menu WHERE menu_id = ?";
		
		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new MenuMapper());
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
    }

    public void addMenu(MenuDto menu) {
        StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO cafelounge_db.menu (menu_name, menu_price, menu_category, menu_image) ")
		    .append("VALUES (?, ?, ?, ?)");

	
		getJdbcTemplate().update(sql.toString(),
            menu.getName(),
            menu.getPrice(),
            menu.getCategory(),
            menu.getImage());
    }

}
