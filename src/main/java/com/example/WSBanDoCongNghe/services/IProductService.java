package com.example.WSBanDoCongNghe.services;

import com.example.WSBanDoCongNghe.model.Product;

import java.util.ArrayList;
import java.util.Optional;

public interface IProductService {
    ArrayList<Product> getAll();
    Optional<Product> getById(int id);
    Product save(Product product);
    void delete(int id);
}
