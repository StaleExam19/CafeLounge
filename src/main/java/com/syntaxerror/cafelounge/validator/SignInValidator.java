package com.syntaxerror.cafelounge.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syntaxerror.cafelounge.model.UserForm;

@Component
public class SignInValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return 	UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Check if form has an empty field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "This field is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "This field is required");
	}

}
