package com.example.WSBanDoCongNghe.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order")
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cart_id")
    private int cart_id;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "total_price")
    private Double totalPrice;
}
