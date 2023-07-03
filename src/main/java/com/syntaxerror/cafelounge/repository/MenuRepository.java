package com.syntaxerror.cafelounge.repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.MenuDto;

@Repository
public class MenuRepository extends NamedParameterJdbcDaoSupport{
    @Autowired
    protected DataSource dataSource;

    @PostConstruct
    private void init() {
        super.setDataSource(dataSource);
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
