package com.syntaxerror.cafelounge.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    if (session.getAttribute("user") == null) return "redirect:/signin";

		return "dashboard";
	}
}
