package com.syntaxerror.cafelounge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.service.MenuService;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/menulist")
    String menuList(Model model, HttpSession session) {
        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        List<MenuDto> menuList = menuService.getAllMenu();

        model.addAttribute("menuList", menuList);
        return "menulist";
    }

    @RequestMapping("/addmenu")
    String addMenuPage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        model.addAttribute("menuForm", new MenuForm());
        return "addmenu";
    }

    @RequestMapping(value = "/addmenu", method = RequestMethod.POST)
    String addMenu(RedirectAttributes redirectAttributes,
            @ModelAttribute("menuForm") MenuForm menuForm) throws IOException {

        menuService.addMenu(menuForm);

        return "redirect:/addmenu";
    }
}
