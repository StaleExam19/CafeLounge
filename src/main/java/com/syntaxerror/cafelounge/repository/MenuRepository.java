package com.syntaxerror.cafelounge.repository;

import java.util.List;

import com.syntaxerror.cafelounge.dto.MenuDto;

public interface MenuRepository {
    List<MenuDto> getAllMenu();
    MenuDto findById(int id);

    List<MenuDto> getMenuByCategoryAndStatus(String category, String status);
    List<MenuDto> getMenuByStatus(String status);
    void addMenu(MenuDto menuDto);

    int countLiveMenu();
}
