package com.syntaxerror.cafelounge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.repository.ChefRepository;

@Service
public class ChefService {
	@Autowired
	ChefRepository userRepository;
	
	public ChefDto searchUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	public void updateProfile(ChefDto user) {
		userRepository.updateProfile(user);
	}

}
