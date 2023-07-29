package com.syntaxerror.cafelounge.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syntaxerror.cafelounge.model.Order;
import com.syntaxerror.cafelounge.repository.OrderRepository;

@Controller
@RequestMapping("/api")
public class OrderRestController {
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/orders")
    ResponseEntity<String> allMenu(@RequestParam(value = "search", defaultValue = "") String search) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> responses = orderRepository.getAllOrders();

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
