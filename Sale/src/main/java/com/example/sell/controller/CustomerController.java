package com.example.sell.controller;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.ResponseCustomer;
import com.example.sell.entity.Customer;
import com.example.sell.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/findAll")
    List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/findCustomer/{id}")
    Customer findById(@PathVariable(name = "id") int id ){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/add")
    ResponseEntity<ResponseCustomer> addCustomer(@RequestBody DtoAddCustomer dtoCustomer){
        return new ResponseEntity<>(customerService.addCustomer(dtoCustomer), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    ResponseEntity<ResponseCustomer> updateCustomer(@RequestBody DtoUpdateCustomer dtoUpdateCustomer){
      return new ResponseEntity<>(customerService.updateCustomer(dtoUpdateCustomer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseCustomer> deleteCustomer(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

}
