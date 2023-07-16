package com.syntaxerror.cafelounge.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuCategory;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.service.MenuService;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @ModelAttribute
    void aso(Model model) {
        MenuCategory arr[] = {
                new MenuCategory("appetizer", "APPETIZERS"),
                new MenuCategory("main-course", "MAIN COURSE"),
                new MenuCategory("dessert", "DESSERTS"),
                new MenuCategory("drink", "DRINKS")
        };

        List<MenuCategory> categories = Arrays.asList(arr);
        model.addAttribute("categories", categories);
    }

    @RequestMapping("/menulist")
    String menuList(Model model,
            HttpSession session,
            @RequestParam(value = "status", defaultValue = "live") String status) {

        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        List<MenuDto> menuList = menuService.getMenuByStatus(status);

        model.addAttribute("menuList", menuList);
        model.addAttribute("menuForm", new MenuForm());
        return "menulist";
    }

    @RequestMapping("/menulist/{category}")
    String filteredMenuList(Model model,
            HttpSession session,
            @PathVariable("category") String category,
            @RequestParam(value = "status", defaultValue = "live") String status) {

        if (session.getAttribute("user") == null)
            return "redirect:/signin";

        List<MenuDto> menuList = menuService.getMenuByCategoryAndStatus(category, status);

        model.addAttribute("menuList", menuList);
        model.addAttribute("menuForm", new MenuForm());
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
            HttpSession session,
            @ModelAttribute("menuForm") MenuForm menuForm) {

        ChefDto currentUser = (ChefDto) session.getAttribute("user");

        try {
            menuService.addMenu(menuForm, currentUser.getFirstname() + " " + currentUser.getLastname());
            return "redirect:/menulist";
        } catch (IOException e) {
            return "redirect:/addmenu";
        }

    }


}
