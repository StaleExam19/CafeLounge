package com.syntaxerror.cafelounge.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.repository.MenuRepository;
import com.syntaxerror.cafelounge.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuRepository menuRepository;

	@Override
	public List<MenuDto> getAllMenu() {
		return menuRepository.getAllMenu();
	}

	@Override
	public MenuDto findById(int id) {
		return menuRepository.findById(id);
	}

	@Override
	public List<MenuDto> getMenuByCategoryAndStatus(String category, String status) {
		return menuRepository.getMenuByCategoryAndStatus(category, status);
	}

	@Override
	public List<MenuDto> getMenuByStatus(String status) {
		return menuRepository.getMenuByStatus(status);
	}

	@Override
	public void addMenu(MenuForm menuForm, String addedBy) throws IOException {
		MenuDto menuDto = new MenuDto();

		System.out.println(addedBy);

		menuDto.setName(menuForm.getName());
		menuDto.setDescription(menuForm.getDescription());
		menuDto.setPrice(menuForm.getPrice());
		menuDto.setCategory(menuForm.getCategory());
		menuDto.setStatus(menuForm.getStatus());
		menuDto.setImage(menuForm.getImage().getBytes());
		menuDto.setAddedBy(addedBy);

		menuRepository.addMenu(menuDto);
	}
}
