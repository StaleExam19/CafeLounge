package com.syntaxerror.cafelounge.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syntaxerror.cafelounge.model.UserForm;
import com.syntaxerror.cafelounge.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	/**
	 * For the dashboard page
	 */
	@RequestMapping("/")
	public String dashboard(Model model, HttpSession session) {
	    // Check if the user is logged in
	    if (session.getAttribute("user") == null) {
	        return "redirect:/signin";
	    }
	    
	    // Set dynamic body content
	    model.addAttribute("bodyContent", "home");

	    return "viewTemplate";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
	    // Set dynamic body content
	    model.addAttribute("bodyContent", "dashboard");

	    return "viewTemplate";
	}
	
	@RequestMapping("/menulist")
	public String menulist(Model model) {
	    // Set dynamic body content
	    model.addAttribute("bodyContent", "menulist");

	    return "viewTemplate";
	}
	
	@RequestMapping("/orderlist")
	public String orderlist(Model model) {
	    // Set dynamic body content
	    model.addAttribute("bodyContent", "orderlist");

	    return "viewTemplate";
	}
	
	
	/**
	 * For the sign in page
	 */
	@RequestMapping("/signin")
	String signInPage(Model model,
			HttpSession session,
			@ModelAttribute("error") String error) {
		// Atung i-redirect sa dashboard kung nakalogin na
		if (session.getAttribute("user") != null) return "redirect:/";
		
		model.addAttribute("userForm", new UserForm());
		return "SignIn";
	}
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	String signIn(RedirectAttributes redirectAttribute,
			HttpSession session,
			@ModelAttribute("userForm") UserForm userForm) {
		UserForm matchedUser = userService.searchUserByUsername(userForm.getUsername());
		
		// Check if one of the input fields are empty
		if (userForm.getUsername().isEmpty() || userForm.getPassword().isEmpty()) {
			redirectAttribute.addFlashAttribute("error", "Please fill all the required fields");
			return "redirect:/signin";
		}
		
		// Check if user doesn't exist
		if (matchedUser == null) {
			redirectAttribute.addFlashAttribute("error", "You entered an incorrect username");
			return "redirect:/signin";
		}
		
		// Check if password is incorrect oy
		if (!matchedUser.getPassword().equals(userForm.getPassword())) {
			redirectAttribute.addFlashAttribute("error", "You entered the incorrect password");
			return "redirect:/signin";
		}
		
		// Kung walay error, atung ibutang ang user sa session
		session.setAttribute("user", matchedUser);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
