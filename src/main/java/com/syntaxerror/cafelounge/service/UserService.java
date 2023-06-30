package com.syntaxerror.cafelounge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.model.UserForm;
import com.syntaxerror.cafelounge.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserDto searchUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	public void updateProfile(int id, UserForm user) {
		userRepository.updateProfile(id, user);
	}

}
