package com.example.WSBanDoCongNghe.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "product")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "category_id")
    private String category_id;
}
