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
import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.service.OrderService;

@Controller
@RequestMapping("/api")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/orders")
    ResponseEntity<String> orderList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderDto> orders = orderService.getAllOrders();

        String jsonResponse;

        try {
            jsonResponse = objectMapper.writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
    }

    @RequestMapping("/orders/{customerId}")
    ResponseEntity<String> getById(@PathVariable("customerId") int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderDto> orders = orderService.getOrdersByCustomerId(id);

        String jsonResponse;

        try {
            jsonResponse = objectMapper.writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
    }
}
