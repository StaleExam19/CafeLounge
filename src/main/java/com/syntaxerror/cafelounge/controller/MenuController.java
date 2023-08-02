package com.syntaxerror.cafelounge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.model.MenuForm;
import com.syntaxerror.cafelounge.service.MenuService;
import com.syntaxerror.cafelounge.util.BtnLink;
import com.syntaxerror.cafelounge.validator.AddMenuValidator;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Autowired
    AddMenuValidator validator;

    @ModelAttribute
    void init(Model model, HttpSession session) {
        List<BtnLink> categories = new ArrayList<>();
        List<BtnLink> btns = new ArrayList<BtnLink>();

        categories.add(new BtnLink("appetizer", "appetizers"));
        categories.add(new BtnLink("main course", "main course"));
        categories.add(new BtnLink("dessert", "desserts"));
        categories.add(new BtnLink("drink", "drinks"));

        btns.add(new BtnLink("/", "Dashboard"));
        btns.add(new BtnLink("/menulist", "Menu List", true));
        btns.add(new BtnLink("/orderlist", "Order List"));

        model.addAttribute("pageTitle", "Menu List");
        model.addAttribute("categories", categories);
        model.addAttribute("sideNavBtn", btns);
        model.addAttribute("naaySearch", true);

        ChefDto user = (ChefDto) session.getAttribute("user");
		model.addAttribute("firstLetter", user.getFirstname().charAt(0));

    }

    @RequestMapping("/menulist")
    String menuList(Model model) {
        return "redirect:menulist/appetizer";
    }

    @RequestMapping("/menulist/{category}")
    String filteredMenuList(Model model,
            HttpSession session,
            @PathVariable("category") String category,
            @RequestParam(value = "status", defaultValue = "live") String status,
            @RequestParam(value = "id", defaultValue = "") String id,
            @ModelAttribute("error") String error) {

        List<MenuDto> menuList = new ArrayList<>();

        if (id.isEmpty())
            menuList = menuService.getMenuByCategoryAndStatus(category, status);
        else
            menuList.add(menuService.getMenuById(Integer.parseInt(id)));
            
        model.addAttribute("menuList", menuList);
        model.addAttribute("menuForm", new MenuForm());
        model.addAttribute("category", category);
        model.addAttribute("status", status);

        model.addAttribute("pageTitle", "Menu List | " + category);
        return "menulist";
    }

    @RequestMapping(value = "/addmenu", method = RequestMethod.POST)
    String addMenu(RedirectAttributes redirectAttributes,
            HttpSession session,
            @ModelAttribute("menuForm") MenuForm menuForm,
            BindingResult bindingResult) {

        ChefDto currentUser = (ChefDto) session.getAttribute("user");

        // Validate menu form
        validator.validate(menuForm, bindingResult);
        FieldError fieldError = bindingResult.getFieldError();
        String error = fieldError == null ? "" : fieldError.getDefaultMessage();

        // Check if error exists
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/menulist";
        }

        try {
            menuService.addMenu(menuForm, currentUser.getFirstname() + " " + currentUser.getLastname());
            return "redirect:/menulist";
        } catch (IOException e) {
            return "redirect:/addmenu";
        }
    }

    @RequestMapping(value = "/updateMenu/{id}", method = RequestMethod.POST)
    String updateMenu(RedirectAttributes redirectAttributes,
            HttpSession session,
            @ModelAttribute("menuForm") MenuForm menuForm,
            @PathVariable("id") int id) throws IOException {
        ChefDto currentUser = (ChefDto) session.getAttribute("user");

        menuService.updateMenuById(id, menuForm, currentUser.getFirstname() + " " + currentUser.getLastname());
        return "redirect:/menulist";
    }

}
