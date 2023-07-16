package com.syntaxerror.cafelounge.repository;

import com.syntaxerror.cafelounge.dto.ChefDto;

public interface ChefRepository {
    ChefDto findByUsername(String username);
    void updateProfile(ChefDto user);
}
