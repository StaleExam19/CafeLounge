package com.syntaxerror.cafelounge.service;

import java.util.List;

import com.syntaxerror.cafelounge.model.Customer;
import com.syntaxerror.cafelounge.model.Menu;

public interface CustomerService {
    List<Customer> getAllCustomersWithOrder();

    List<Menu> getOrdersByCustomerId(int customerId);

    Customer getCustomerWithOrderbyCustomerId(int customerId);
}
