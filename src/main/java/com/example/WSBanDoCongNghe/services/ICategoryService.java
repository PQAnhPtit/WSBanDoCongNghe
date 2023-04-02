package com.example.WSBanDoCongNghe.services;

import com.example.WSBanDoCongNghe.model.Category;

import java.util.ArrayList;
import java.util.Optional;

public interface ICategoryService {
    ArrayList<Category> getAll();
    Optional<Category> getById(int id);
    Category save(Category category);
    void delete(int id);
}
