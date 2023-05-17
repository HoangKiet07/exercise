package com.example.sell.service;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.ResponseCustomer;
import com.example.sell.entity.Customer;
import com.example.sell.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> findAll();

    public ResponseCustomer addCustomer(DtoAddCustomer dtoCustomer) throws BusinessException;

    public Customer findCustomerById(int id) throws BusinessException;

    public ResponseCustomer deleteCustomer(int id) throws BusinessException;

    public ResponseCustomer updateCustomer(DtoUpdateCustomer dtoUpdateCustomer) throws BusinessException;

}
