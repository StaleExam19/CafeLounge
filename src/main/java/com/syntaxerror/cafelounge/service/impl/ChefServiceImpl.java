package com.syntaxerror.cafelounge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.repository.impl.ChefRepositoryImpl;
import com.syntaxerror.cafelounge.service.ChefService;

@Service
public class ChefServiceImpl implements ChefService {
	@Autowired
	ChefRepositoryImpl userRepository;

	@Override
	public ChefDto searchUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void updateProfile(ChefDto user) {
		userRepository.updateProfile(user);
	}

}
