package com.example.sell.service;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.ResponseCustomer;
import com.example.sell.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> findAll();

    public ResponseCustomer addCustomer(DtoAddCustomer dtoCustomer);

    public Customer findCustomerById(int id);

    public ResponseCustomer deleteCustomer(int id);

    public ResponseCustomer updateCustomer(DtoUpdateCustomer dtoUpdateCustomer);

}
