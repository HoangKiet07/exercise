package com.example.sell.controller;

import com.example.sell.dto.request.Customer.DtoAddCustomer;
import com.example.sell.dto.request.Customer.DtoUpdateCustomer;
import com.example.sell.dto.response.Customer.Response;
import com.example.sell.entity.Customer;
import com.example.sell.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    Optional<Customer> findById(@PathVariable(name = "id") int id ){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/add")
    Response addCustomer(@RequestBody DtoAddCustomer dtoCustomer){
        return customerService.addCustomer(dtoCustomer);
    }


    @PutMapping("/updateCustomer")
    ResponseEntity<Response> updateCustomer(@RequestBody DtoUpdateCustomer dtoUpdateCustomer){
        if(customerService.updateCustomer(dtoUpdateCustomer)== 1){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("OK", "UPDATE SUCCESSFULL", dtoUpdateCustomer)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Response("NOT FOUND", "UPDATE FAILED", "")
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Response> deleteCustomer(@PathVariable(name = "id") int id){
        if (customerService.deleteCustomer(id) == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Response("NOT FOUND", "DELETE FAILED", "")
            );
        } else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("OK", "DELETE SUCCESSFULL", customerService.findCustomerById(id))
            );
        }
    }

}
