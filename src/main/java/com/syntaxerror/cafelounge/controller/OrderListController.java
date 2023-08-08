package com.syntaxerror.cafelounge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syntaxerror.cafelounge.dto.ChefDto;
import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.model.OrderItem;
import com.syntaxerror.cafelounge.service.CustomerService;
import com.syntaxerror.cafelounge.service.OrderService;
import com.syntaxerror.cafelounge.util.BtnLink;

@Controller
public class OrderListController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @ModelAttribute
    void init(Model model, HttpSession session) {
        List<BtnLink> btns = new ArrayList<BtnLink>();

        btns.add(new BtnLink("/", "Dashboard"));
        btns.add(new BtnLink("/menulist", "Menu List"));
        btns.add(new BtnLink("/orderlist", "Order List", true));

        model.addAttribute("pageTitle", "Order List");
        model.addAttribute("sideNavBtn", btns);

        ChefDto user = (ChefDto) session.getAttribute("user");
        model.addAttribute("firstLetter", user.getFirstname().charAt(0));

    }

    @RequestMapping("/orderlist")
    String orderListPage(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        List<Order> orders = orderService.paginateOrder(page);

        model.addAttribute("orders", orders);
        model.addAttribute("orderSearch", true);
        model.addAttribute("numOfPages", orderService.countPage());
        model.addAttribute("currentPage", page);
        return "orderlist";
    }

    @RequestMapping("/order/{orderNumber}")
    String orderDetails(Model model,
            @PathVariable("orderNumber") int id) {
        Order order = orderService.getOrderByOrderNumber(id);
        double total = 0;

        for (OrderItem item : order.getOrders()) {
            total += item.getPrice() * item.getQuantity();
        }

        model.addAttribute("order", order);
        model.addAttribute("total", total);

        return "orderdetail";
    }

    @RequestMapping("/orderlist/{status}")
    String orderFilteredByStatus(Model model,
            @PathVariable("status") String status,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        List<Order> orders = orderService.paginateOrderWithStatus(page, status);


        model.addAttribute("orders", orders);
        model.addAttribute("pageTitle", "Order List | " + status);
        model.addAttribute("orderSearch", true);
        model.addAttribute("currentPage", page);
        model.addAttribute("numOfPages", orderService.countOrderWithStatus(status));

        return "orderlist";
    }

    @RequestMapping("/completeOrder/{orderNumber}")
    String completeOrder(Model model, @PathVariable("orderNumber") int orderNumber) {
        orderService.updateStatusByOrderNumber(orderNumber, "completed");
        return "redirect:/order/" + orderNumber;
    }

    @RequestMapping("/cancelOrder/{id}")
    String cancelOrder(Model model, @PathVariable("id") int id) {
        orderService.updateStatusByOrderNumber(id, "canceled");
        return "redirect:/orderlist";
    }
}
