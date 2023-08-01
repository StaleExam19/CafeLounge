package com.syntaxerror.cafelounge.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.service.MenuService;

@Controller
public class ImageController {

    @Autowired
    MenuService menuService;
    
    @RequestMapping("/images")
    public void showImage(@RequestParam("id") int id, HttpServletResponse response) throws IOException {
        MenuDto menu = menuService.findById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif"); 
        response.getOutputStream().write(menu.getImage());

        response.getOutputStream().close();
    }
}
