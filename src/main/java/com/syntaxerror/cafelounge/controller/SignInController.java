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
import com.syntaxerror.cafelounge.validator.SignInValidator;

@Controller
public class SignInController {
    @Autowired
    SignInValidator validator;

    @Autowired
    ChefService userService;

    @ModelAttribute
    void init(Model model)  {
        model.addAttribute("pageTitle", "Sign In");
    }

    @RequestMapping("/signin")
    String signInPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null)
            return "redirect:/";

        model.addAttribute("userForm", new ChefForm());
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    String signIn(RedirectAttributes redirectAttributes,
            HttpSession session,
            @ModelAttribute("userForm") ChefForm userForm,
            BindingResult bindingResult) {

        validator.validate(userForm, bindingResult);
        FieldError fieldError = bindingResult.getFieldError();
        String error = fieldError == null ? "" : fieldError.getDefaultMessage();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/signin";
        }
        ChefDto matchedUser = userService.searchUserByUsername(userForm.getUsername());
        session.setAttribute("user", matchedUser);

        if (matchedUser.getDateUpdated() == null) {
            redirectAttributes.addFlashAttribute("message",
                    "You signed in for the first time, please update your profile");
            return "redirect:/updateProfile";
        }

        return "redirect:/";
    }

    @RequestMapping("/logout")
    String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
