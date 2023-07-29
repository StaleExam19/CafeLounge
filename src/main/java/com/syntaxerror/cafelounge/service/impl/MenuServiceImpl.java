package com.syntaxerror.cafelounge.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.MenuApiDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.repository.MenuRepository;
import com.syntaxerror.cafelounge.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuRepository menuRepository;

	@Override
	public List<MenuApiDto> getAllMenu() {
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
		menuDto.setPrice(Double.parseDouble(menuForm.getPrice()));
		menuDto.setCategory(menuForm.getCategory());
		menuDto.setStatus(menuForm.getStatus());
		menuDto.setQuantity(Integer.parseInt(menuForm.getQuantity()));
		menuDto.setImage(menuForm.getImage().getBytes());
		menuDto.setAddedBy(addedBy);

		menuRepository.addMenu(menuDto);
	}

	@Override
	public int countLiveMenu() {
		return menuRepository.countLiveMenu();
	}

	@Override
	public void deleteById(int id) {
		menuRepository.deleteById(id);
	}

	@Override
	public MenuDto getMenuById(int id) {
		return menuRepository.findById(id);
	}

	@Override
	public void updateMenuById(int id, MenuForm menuForm, String updatedBy) {
		MenuDto menu = menuRepository.findById(id);

		menu.setName(menuForm.getName());
		menu.setDescription(menuForm.getDescription());
		menu.setPrice(Double.parseDouble(menuForm.getPrice()));
		menu.setCategory(menuForm.getCategory());
		menu.setStatus(menuForm.getStatus());

		menu.setQuantity(Integer.parseInt(menuForm.getQuantity()));

		try {
			menu.setImage(menuForm.getImage().getBytes());
		} catch (IOException e) {
		}
		menu.setAddedBy(updatedBy);
		
		menuRepository.updateMenuById(id, menu, updatedBy);
	}

	@Override
	public List<MenuApiDto> searchMenuByName(String search) {
		return menuRepository.searchMenuByName(search);
	}
}
