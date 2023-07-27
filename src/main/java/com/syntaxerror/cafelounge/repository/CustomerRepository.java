package com.syntaxerror.cafelounge.repository;

import com.syntaxerror.cafelounge.dto.CustomerDto;

public interface CustomerRepository {
    CustomerDto getCustomerById(int id);
}
