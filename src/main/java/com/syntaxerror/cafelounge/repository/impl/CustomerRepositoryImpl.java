package com.syntaxerror.cafelounge.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.dto.CustomerDto;
import com.syntaxerror.cafelounge.dto.MenuDto;
import com.syntaxerror.cafelounge.dto.OrderDto;
import com.syntaxerror.cafelounge.mapper.CustomerMapper;
import com.syntaxerror.cafelounge.mapper.OrderMapper;
import com.syntaxerror.cafelounge.model.Customer;
import com.syntaxerror.cafelounge.model.Menu;
import com.syntaxerror.cafelounge.repository.CustomerRepository;
import com.syntaxerror.cafelounge.repository.MenuRepository;

@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl implements CustomerRepository {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Customer> getAllCustomersWithOrder() {
        String sql = "SELECT * FROM cafelounge_db.customer WHERE 1";
        List<CustomerDto> customerDtos = getJdbcTemplate().query(sql, new CustomerMapper());
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < customerDtos.size(); i++) {
            CustomerDto customerDto = customerDtos.get(i);
            List<Menu> orders = getOrdersByCustomerId(customerDto.getId());
            Customer customer = new Customer();

            customer.setFirstname(customerDto.getFirstname());
            customer.setLastname(customerDto.getLastname());
            customer.setOrders(orders);

            customers.add(customer);
        }

        return customers;
    }

    @Override
    public List<Menu> getOrdersByCustomerId(int customerId) {
        String sql = "SELECT * FROM cafelounge_db.`order` WHERE customer_id = ?";

        try {
            List<OrderDto> orderDtos = getJdbcTemplate().query(sql, new Object[] { customerId }, new OrderMapper());
            List<Menu> orders = new ArrayList<>();

            for (int i = 0; i < orderDtos.size(); i++) {
                OrderDto orderDto = orderDtos.get(i);
                MenuDto menu = menuRepository.getMenuById(orderDto.getMenuId());
                Menu order = new Menu();

                order.setMenuName(menu.getName());
                order.setQuantity(orderDto.getQuantity());
                order.setDateOrdered(orderDto.getDateOrdered());

                orders.add(order);
            }
            return orders;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Customer getCustomerWithOrderbyCustomerId(int customerId) {
        String sql = "SELECT * FROM cafelounge_db.customer WHERE id = ?";

        try {
            CustomerDto customerDto = getJdbcTemplate().queryForObject(sql, new Object[] { customerId },
                    new CustomerMapper());
            Customer customer = new Customer();
            List<Menu> orders = getOrdersByCustomerId(customerId);

            customer.setFirstname(customerDto.getFirstname());
            customer.setLastname(customerDto.getLastname());

            customer.setOrders(orders);

            return customer;
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM cafelounge_db.customer WHERE id = ?";


        try {
            CustomerDto customerDto =  getJdbcTemplate().queryForObject(sql, new Object[] {id}, new CustomerMapper());
            Customer customer = new Customer();

            customer.setFirstname(customerDto.getFirstname());
            customer.setLastname(customerDto.getLastname());

            return customer;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
