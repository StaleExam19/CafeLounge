package com.syntaxerror.cafelounge.service;

import java.io.IOException;
import java.util.List;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;

public interface MenuService {
    List<MenuDto> getAllMenu();
    MenuDto findById(int id);
    List<MenuDto> getMenuByCategoryAndStatus(String category, String status);
    List<MenuDto> getMenuByStatus(String status);
    void addMenu(MenuForm menuForm, String addedBy) throws IOException;
}
