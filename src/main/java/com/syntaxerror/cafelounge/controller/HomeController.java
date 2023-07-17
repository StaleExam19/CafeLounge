package com.syntaxerror.cafelounge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syntaxerror.cafelounge.service.ChefService;
import com.syntaxerror.cafelounge.service.MenuService;
import com.syntaxerror.cafelounge.util.BtnLink;

@Controller
public class HomeController {
	@Autowired
	ChefService userService;

	@Autowired
	MenuService menuService;

	@ModelAttribute
	void prepare(Model model, HttpSession session, HttpServletRequest request) {
		List<BtnLink> btns = new ArrayList<BtnLink>();

		btns.add(new BtnLink("/", "Dashboard", true));
		btns.add(new BtnLink("/menulist", "Menu List"));
		btns.add(new BtnLink("/orderlist", "Order List"));

		model.addAttribute("sideNavBtn", btns);
	}

	/**
	 * For the dashboard page
	 */
	@RequestMapping("/")
	public String dashboard(Model model) {

		model.addAttribute("liveMenu", menuService.countLiveMenu());
		return "dashboard";
	}

}
