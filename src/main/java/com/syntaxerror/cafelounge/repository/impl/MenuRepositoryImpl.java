package com.syntaxerror.cafelounge.repository.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.mapper.MenuMapper;
import com.syntaxerror.cafelounge.repository.MenuRepository;

@Repository
public class MenuRepositoryImpl extends BaseRepositoryImpl implements MenuRepository {
	@Override
	public List<MenuDto> getAllMenu() {
		String sql = "SELECT * FROM cafelounge_db.menu WHERE 1";
		try {
			return getJdbcTemplate().query(sql, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
			return null; // Return null or any other value to indicate no matching rows
		}
	}

	@Override
	public MenuDto findById(int id) {
		String sql = "SELECT * FROM cafelounge_db.menu WHERE id = ?";

		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<MenuDto> getMenuByCategoryAndStatus(String category, String status) {
		String sql;

		if (status == "sold out") {
			sql = "SELECT * FROM cafelounge_db.menu WHERE category = ? AND status = ? AND quantity = 0";
		} else {
			sql = "SELECT * FROM cafelounge_db.menu WHERE category = ? AND status = ?";
		}
		try {
			return getJdbcTemplate().query(sql, new Object[] { category, status }, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
			return null; // Return null or any other value to indicate no matching rows
		}
	}

	@Override
	public List<MenuDto> getMenuByStatus(String status) {
		String sql = "SELECT * FROM cafelounge_db.menu WHERE status = ?";
		try {
			return getJdbcTemplate().query(sql, new Object[] { status }, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
			return null; // Return null or any other value to indicate no matching rows
		}
	}

	@Override
	public void addMenu(MenuDto menu) {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO cafelounge_db.menu (name, description, price, status, category, image, added_by) ")
				.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

		getJdbcTemplate().update(sql.toString(),
				menu.getName(),
				menu.getDescription(),
				menu.getPrice(),
				menu.getStatus(),
				menu.getCategory(),
				menu.getImage(),
				menu.getAddedBy());
	}

	@Override
	public int countLiveMenu() {
		String sql = "SELECT COUNT(*) FROM cafelounge_db.menu WHERE status = \"live\" AND date_delisted IS NULL";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public void deleteById(int id) {
		String sql = "UPDATE cafelounge_db.menu SET date_delisted = CURRENT_TIMESTAMP, status = \"delisted\" WHERE id = ?";
		getJdbcTemplate().update(sql, id);
	}

	@Override
	public MenuDto getMenuById(int id) {
		String sql = "SELECT * FROM cafelounge_db.menu WHERE id = ?";

		try {
			return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new MenuMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void updateMenuById(int id, MenuDto menuDto, String updatedBy) {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE cafelounge_db.menu")
				.append(" SET name = ?, quantity = ?, description = ?, ");

		// Update the date_delisted if user set the status to delisted
		if (menuDto.getStatus() == "delisted")
			sql.append("date_delisted = CURRENT_TIMESTAMP, ");
		else
			sql.append("date_delisted = NULL, ");

		sql.append("category = ?, price = ?, status = ?, updated_by = ? ")
				.append("WHERE id = ?");

		getJdbcTemplate().update(sql.toString(),
				menuDto.getName(),
				menuDto.getQuantity(),
				menuDto.getDescription(),
				menuDto.getCategory(),
				menuDto.getPrice(),
				menuDto.getStatus(),
				menuDto.getUpdatedBy(),
				id);
	}

	@Override
	public void updateQuantity(int id, int quantity) {
		String sql = "UPDATE cafelounge_db.menu SET quantity = ? WHERE id = ?";
		MenuDto menu = getMenuById(id);
		getJdbcTemplate().update(sql, menu.getPrice() - quantity, id);
	}

}
