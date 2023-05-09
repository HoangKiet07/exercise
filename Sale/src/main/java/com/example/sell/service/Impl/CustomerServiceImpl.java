package com.example.sell.service.Impl;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.Response;
import com.example.sell.entity.Customer;
import com.example.sell.repository.CustomerRepository;
import com.example.sell.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @Override
    public Response addCustomer(DtoAddCustomer dtoCustomer) {
        Optional<Customer> customer = customerRepository.findById(dtoCustomer.getId());
        if (customer.isPresent()){
            return new Response("Exist", "Customer exist", "");
        } else{
            Customer customer1 = new Customer();
            customer1.setCustomerName(dtoCustomer.getName());
            customer1.setIdCustomer(dtoCustomer.getId());
            customerRepository.save(customer1);
            return new Response("OK", "Add Successfull", customer1);
        }
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }


    @Override
    public int deleteCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customerRepository.deleteById(id);
            return 1;
        } else{
            return 0;
        }

    }

    @Override
    public int updateCustomer(DtoUpdateCustomer dtoUpdateCustomer) {
        Optional<Customer> customer1 = customerRepository.findById(dtoUpdateCustomer.getId());
        if (customer1.isPresent()){
            Customer customer = new Customer();
            customer.setCustomerName(dtoUpdateCustomer.getName());
            customer.setIdCustomer(dtoUpdateCustomer.getId());
            customerRepository.save(customer);
            return 1;
        } else{
            return 0;
        }

    }

}
