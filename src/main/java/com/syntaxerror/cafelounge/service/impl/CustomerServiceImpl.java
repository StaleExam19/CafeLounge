package com.syntaxerror.cafelounge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.model.Customer;
import com.syntaxerror.cafelounge.model.Menu;
import com.syntaxerror.cafelounge.repository.CustomerRepository;
import com.syntaxerror.cafelounge.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomersWithOrder() {
        return customerRepository.getAllCustomersWithOrder();
    }

    @Override
    public List<Menu> getOrdersByCustomerId(int customerId) {
        return customerRepository.getOrdersByCustomerId(customerId);
    }

    @Override
    public Customer getCustomerWithOrderbyCustomerId(int customerId) {
        return customerRepository.getCustomerWithOrderbyCustomerId(customerId);
    }
    
}
