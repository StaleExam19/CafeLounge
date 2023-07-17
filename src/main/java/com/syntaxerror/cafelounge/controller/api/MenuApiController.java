package com.syntaxerror.cafelounge.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.service.MenuService;


@Controller
@RequestMapping("/api")
public class MenuApiController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/menu")
    ResponseEntity<String> allMenu() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MenuDto> responses = menuService.getAllMenu();

        String jsonResponse;

        try {
            jsonResponse = objectMapper.writeValueAsString(responses);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
    }


    @RequestMapping("/menu/{id}")
    ResponseEntity<String> menuById(@PathVariable("id") int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        MenuDto responses = menuService.findById(id);

        String jsonResponse;

        try {
            jsonResponse = objectMapper.writeValueAsString(responses);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
    }
}
