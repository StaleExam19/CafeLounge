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
	
}
