package com.syntaxerror.cafelounge.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.model.ChefForm;
import com.syntaxerror.cafelounge.service.ChefService;

@Component
public class SignInValidator implements Validator {
	@Autowired
	ChefService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ChefForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Check if form has an empty field
		ChefForm user = (ChefForm) target;
		ChefDto matchedUser = userService.searchUserByUsername(user.getUsername());

		// Check if both fields are blank
		if (user.getUsername().isBlank() && user.getPassword().isBlank()) {
			errors.rejectValue("username", null, "Please fill all the required fields");
			return;
		}

		if (user.getUsername().isBlank() || user.getPassword().isBlank()) {
			if (user.getUsername().isBlank()) {
				errors.rejectValue("username", null, "Username is required");
				return;
			}

			if (user.getPassword().isBlank()) {
				errors.rejectValue("password", null, "Password is required");
				return;
			}
		}


		if (matchedUser != null) {
			if (!matchedUser.getPassword().equals(user.getPassword()))
				errors.rejectValue("password", null, "Incorrect password");
		} else {
			errors.rejectValue("username", null, "There's no user with that username");
		}
	}

}
