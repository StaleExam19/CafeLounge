package com.syntaxerror.cafelounge.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.model.ChefForm;
import com.syntaxerror.cafelounge.service.ChefService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProfileValidator implements Validator {

    @Autowired
    ChefService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ChefForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Check if form has an empty field
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Please fill all the required fields");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", null,
                "Please fill all the required fields");

        ChefForm user = (ChefForm) target;
        ChefDto matchedUser = userService.searchUserByUsername(user.getUsername());

        if (!user.getPassword().equals(user.getConfirmPassword()))
            errors.rejectValue("password", null, "Password doesn't match");

        if (user.getPassword().equals(matchedUser.getPassword()))
            errors.rejectValue("password", null, "You entered the old password");

        if (user.getPassword().length() < 8)
            errors.rejectValue("password", null, "Password must be at least 8 characters long");

    }
}
