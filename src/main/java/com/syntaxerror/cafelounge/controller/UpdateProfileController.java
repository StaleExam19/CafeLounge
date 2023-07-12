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

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.model.ChefForm;
import com.syntaxerror.cafelounge.service.ChefService;
import com.syntaxerror.cafelounge.validator.UpdateProfileValidator;

@Controller
public class UpdateProfileController {
    @Autowired
    ChefService userService;

    @Autowired
    UpdateProfileValidator validator;

    @RequestMapping("/updateProfile")
    String page(Model model,
            @ModelAttribute("error") String error,
            @ModelAttribute("message") String message,
            HttpSession session) {
        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        ChefDto user = (ChefDto) session.getAttribute("user");
        ChefForm userForm = new ChefForm();

        userForm.setUsername(user.getUsername());

        model.addAttribute("userForm", userForm);
        return "updateprofile";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    String update(RedirectAttributes redirectAttribute,
            @ModelAttribute("userForm") ChefForm userForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpSession session) {

        ChefDto currentUser = (ChefDto) session.getAttribute("user");
        ChefDto newUserData = new ChefDto();

        userForm.setUsername(currentUser.getUsername());

        validator.validate(userForm, bindingResult);
        FieldError fieldError = bindingResult.getFieldError();
        String error = fieldError == null ? "" : fieldError.getDefaultMessage();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/updateProfile";
        }


        newUserData.setUsername(userForm.getUsername());
        newUserData.setPassword(userForm.getPassword());
        newUserData.setId(currentUser.getId());

        userService.updateProfile(newUserData);

        System.out.println("Profile successfully updated");
        return "redirect:/";
    }
}
