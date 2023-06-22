package com.syntaxerror.cafelounge.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.model.UserForm;
import com.syntaxerror.cafelounge.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserForm searchUserByUsername(String username) {
		UserForm user = new UserForm();
		UserDto matchedUser = userRepository.findUserByUsername(username);
		
		if (Objects.isNull(matchedUser)) return null;
		
		user.setUsername(matchedUser.getUsername());
		user.setPassword(matchedUser.getPassword());		
		
		return user;
	}
}
