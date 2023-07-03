package com.syntaxerror.cafelounge.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	public void addMenu(MenuForm menuForm) throws IOException {
		MenuDto menuDto = new MenuDto();

		menuDto.setName(menuForm.getName());
		menuDto.setPrice(menuForm.getPrice());
		menuDto.setCategory(menuForm.getCategory());
		menuDto.setImage(menuForm.getImage().getBytes());

		System.out.println(menuDto.getName());
		System.out.println(menuDto.getPrice());
		System.out.println(menuDto.getCategory());
		System.out.println(menuDto.getImage());

		menuRepository.addMenu(menuDto);
	}
}
