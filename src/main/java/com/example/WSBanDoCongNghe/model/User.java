package com.example.WSBanDoCongNghe.model;

import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}
