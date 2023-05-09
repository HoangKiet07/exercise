package com.example.sell.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "customer_name")
    private String customerName;

    @OneToMany(mappedBy = "customer_fk", cascade = CascadeType.ALL)
    private List<Cart> cartList;


    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
