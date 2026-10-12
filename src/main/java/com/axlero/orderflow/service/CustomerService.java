package com.axlero.orderflow.service;


import com.axlero.orderflow.dto.CustomerDtos;

import java.util.List;

public interface CustomerService {

    CustomerDtos createCustomer(CustomerDtos customer);

    CustomerDtos getCustomerById(Long id);

    List<CustomerDtos> getAllCustomers();

    CustomerDtos updateCustomer(Long id, CustomerDtos customer);

    void deleteCustomer(Long id);
}
