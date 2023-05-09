package com.example.sell.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;

    @Column(name = "id_customer_cart")
    private int idCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_customer")
    private Customer customer_fk;

    @OneToMany(mappedBy = "cart_fk", cascade = CascadeType.ALL)
    private List<Order> orderList;

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
