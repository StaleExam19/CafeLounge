package com.syntaxerror.cafelounge.repository;

import java.util.List;

import com.syntaxerror.cafelounge.model.Customer;
import com.syntaxerror.cafelounge.model.Menu;

public interface CustomerRepository {
        List<Customer> getAllCustomersWithOrder();

        List<Menu> getOrdersByCustomerId(int customerId);

        Customer getCustomerWithOrderbyCustomerId(int customerId);

        Customer getCustomerById(int id);
}
