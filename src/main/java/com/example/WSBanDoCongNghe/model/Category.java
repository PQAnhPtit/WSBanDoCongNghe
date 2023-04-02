package com.example.WSBanDoCongNghe.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "category")
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
