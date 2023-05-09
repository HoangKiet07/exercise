package com.example.sell.controller;

import com.example.sell.dto.response.Customer.Response;
import com.example.sell.entity.Product;
import com.example.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findProduct/{id}")
    Optional<Product> findById(@PathVariable(name = "id") int id ){
        return productService.findProductById(id);
    }

    @PostMapping("/add")
    ResponseEntity<Response> addProduct(@RequestBody Product product){
        Optional<Product> product1 = productService.findProductById(product.getIdProduct());
        if (product1.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("Exist", "Product exist", "")
            );
        } else{
            productService.addProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("OK", "Add Successfull", product)
            );
        }
    }

    @PutMapping("/updateProduct")
    ResponseEntity<Response> updateCustomer(@RequestBody Product product){
        Optional<Product> product1 = productService.findProductById(product.getIdProduct());
        if(product1.isPresent()){
            productService.addProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("OK", "UPDATE SUCCESSFULL", product)
            );
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new Response("NOT FOUND", "UPDATE FAILED", "")
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Response> deleteProduct(@PathVariable(name = "id") int id){
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent() == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Response("NOT FOUND", "DELETE FAILED", "")
            );
        } else{
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response("OK", "DELETE SUCCESSFULL", product)
            );
        }
    }

}
