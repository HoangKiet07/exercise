package com.example.sell.service.Impl;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.ResponseCustomer;
import com.example.sell.entity.Customer;
import com.example.sell.exception.BusinessException;
import com.example.sell.mapper.CustomerMapper.CustomerToDtoAddCustomer;
import com.example.sell.mapper.CustomerMapper.CustomerToUpdateCustomer;
import com.example.sell.repository.CustomerRepository;
import com.example.sell.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseCustomer addCustomer(DtoAddCustomer dtoAddCustomer) throws BusinessException {
        Optional<Customer> customer = customerRepository.findById(dtoAddCustomer.getIdCustomer());
        if (customer.isPresent()){
            throw new BusinessException("Customer exits...", HttpStatus.FOUND);
        } else{
            Customer customer1 = CustomerToDtoAddCustomer.instance.toCustomer(dtoAddCustomer);
            customerRepository.save(customer1);
            return new ResponseCustomer("OK", "Add Successfull", customer1);
        }
    }

    @Override
    public Customer findCustomerById(int id) throws BusinessException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }else {
            throw new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseCustomer deleteCustomer(int id) throws BusinessException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customerRepository.deleteById(id);
            return new ResponseCustomer("OK", "Delete Successfull", customer);
        } else{
            throw new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseCustomer updateCustomer(DtoUpdateCustomer dtoUpdateCustomer) throws BusinessException {
        Optional<Customer> customer1 = customerRepository.findById(dtoUpdateCustomer.getIdCustomer());
        if (customer1.isPresent()){
            Customer customer = CustomerToUpdateCustomer.instance.toCustomer(dtoUpdateCustomer);
            customerRepository.save(customer);
            return new ResponseCustomer("OK", "Update Successfull", customer);
        } else{
            throw new BusinessException("Customer Not Found", HttpStatus.NOT_FOUND);
        }

    }

}
