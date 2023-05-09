package com.example.sell.service;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.Response;
import com.example.sell.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> findAll();

    public Response addCustomer(DtoAddCustomer dtoCustomer);

    public Optional<Customer> findCustomerById(int id);

    public int deleteCustomer(int id);

    public int updateCustomer(DtoUpdateCustomer dtoUpdateCustomer);

}
