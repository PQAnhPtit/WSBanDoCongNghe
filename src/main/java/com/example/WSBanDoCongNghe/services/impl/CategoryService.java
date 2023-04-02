package com.example.WSBanDoCongNghe.services.impl;

import com.example.WSBanDoCongNghe.model.Category;
import com.example.WSBanDoCongNghe.repositories.ICategoryRepo;
import com.example.WSBanDoCongNghe.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public ArrayList<Category> getAll() {
        ArrayList<Category> list = new ArrayList<>();
        Iterable it = categoryRepo.findAll();
        for(Object category: it){
            list.add((Category) category);
        }
        return list;
    }

    @Override
    public Optional<Category> getById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
