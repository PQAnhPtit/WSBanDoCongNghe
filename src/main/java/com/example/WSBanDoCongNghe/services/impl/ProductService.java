package com.example.WSBanDoCongNghe.services.impl;

import com.example.WSBanDoCongNghe.model.Product;
import com.example.WSBanDoCongNghe.repositories.IProductRepo;
import com.example.WSBanDoCongNghe.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo productRepo;

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        Iterable it = productRepo.findAll();
        for(Object product: it){
            list.add((Product) product);
        }
        return list;
    }

    @Override
    public Optional<Product> getById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
