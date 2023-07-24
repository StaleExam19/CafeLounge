package com.syntaxerror.cafelounge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.service.OrderService;
import com.syntaxerror.cafelounge.util.BtnLink;

@Controller
public class OrderListController {

    @Autowired
    OrderService orderService;

    @ModelAttribute
    void init(Model model) {
        List<BtnLink> btns = new ArrayList<BtnLink>();

        btns.add(new BtnLink("/", "Dashboard"));
        btns.add(new BtnLink("/menulist", "Menu List"));
        btns.add(new BtnLink("/orderlist", "Order List", true));

        model.addAttribute("pageTitle", "Order List");
        model.addAttribute("sideNavBtn", btns);
		model.addAttribute("naaySearch", true);

    }

    @RequestMapping("/orderlist")
    String orderListPage(Model model) {
        List<OrderDto> orders = orderService.getAllOrders();
        
        model.addAttribute("orders", orders);
        return "orderlist";
    }
}
