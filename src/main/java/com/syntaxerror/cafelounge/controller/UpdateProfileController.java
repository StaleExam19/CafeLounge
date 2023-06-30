package com.syntaxerror.cafelounge.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syntaxerror.cafelounge.dto.UserDto;
import com.syntaxerror.cafelounge.model.UserForm;
import com.syntaxerror.cafelounge.service.UserService;
import com.syntaxerror.cafelounge.validator.UpdateProfileValidator;

@Controller
public class UpdateProfileController {
    @Autowired
    UserService userService;

    @Autowired
    UpdateProfileValidator validator;

    @RequestMapping("/updateProfile")
    String page(Model model,
            @ModelAttribute("error") String error,
            @ModelAttribute("message") String message,
            HttpSession session) {
        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        UserDto user = (UserDto) session.getAttribute("user");

        if (user.getFirstname() == null)
            user.setFirstname("");
        if (user.getLastname() == null)
            user.setLastname("");
        
        UserForm userForm = new UserForm(
            user.getFirstname().isBlank() ? "" : user.getFirstname(),
            user.getLastname().isBlank() ? "" : user.getLastname(),
            user.getUsername(),
            user.getPassword()
        );
        model.addAttribute("userForm", userForm);
        return "updateProfile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    String update(RedirectAttributes redirectAttribute,
            @ModelAttribute("userForm") UserForm userForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpSession session) {

        validator.validate(userForm, bindingResult);
        FieldError fieldError = bindingResult.getFieldError();
        String error = fieldError == null ? "" : fieldError.getDefaultMessage();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/updateProfile";
        }

        UserDto currentUser = (UserDto) session.getAttribute("user");

        userService.updateProfile(currentUser.getId(), userForm);
        System.out.println("Profile successfully updated");
        return "redirect:/";
    }
}
