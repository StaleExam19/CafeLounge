package com.syntaxerror.cafelounge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderListController {
    
    @RequestMapping("/orderlist")
    String orderListPage(Model model) {
        
        return "orderlist";
    }
}
