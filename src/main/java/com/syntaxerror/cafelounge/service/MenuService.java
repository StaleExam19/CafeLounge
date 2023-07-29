package com.syntaxerror.cafelounge.service;

import java.io.IOException;
import java.util.List;

import com.syntaxerror.cafelounge.dto.MenuApiDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;

public interface MenuService {
    MenuDto findById(int id);

    List<MenuApiDto> getAllMenu();
    List<MenuDto> getMenuByCategoryAndStatus(String category, String status);
    List<MenuDto> getMenuByStatus(String status);

    void addMenu(MenuForm menuForm, String addedBy) throws IOException;
    void deleteById(int id);
    void updateMenuById(int id, MenuForm menuForm, String updatedBy);

    MenuDto getMenuById(int id);

    int countLiveMenu();

    List<MenuApiDto> searchMenuByName(String search);
}
