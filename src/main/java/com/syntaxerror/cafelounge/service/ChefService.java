package com.syntaxerror.cafelounge.service;

import com.syntaxerror.cafelounge.dto.ChefDto;

public interface ChefService {
    ChefDto searchUserByUsername(String username);
    void updateProfile(ChefDto user);
}
