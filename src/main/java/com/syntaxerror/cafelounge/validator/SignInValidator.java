package com.syntaxerror.cafelounge.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.model.UserForm;
import com.syntaxerror.cafelounge.service.UserService;

@Component
public class SignInValidator implements Validator {
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Check if form has an empty field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Please fill all the required fields");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Please fill all the required fields");

		UserForm user = (UserForm) target;
		UserDto matchedUser = userService.searchUserByUsername(user.getUsername());

		if (matchedUser != null) {
			if (!matchedUser.getPassword().equals(user.getPassword()))
				errors.rejectValue("password", null, "Incorrect password");
		} else {
			errors.rejectValue("username", null, "There's no user with that username");
		}
	}

}
