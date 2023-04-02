package com.example.WSBanDoCongNghe.controllers;

import com.example.WSBanDoCongNghe.model.Category;
import com.example.WSBanDoCongNghe.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Category> add(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> edit(@PathVariable int id){
        Category category = categoryService.getById(id).get();
        if(category != null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Optional<Category> categoryOptional = categoryService.getById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> doEdit(@PathVariable("id") int id, @RequestBody Category category) {
        Category categoryNew = categoryService.getById(id).get();
        if(categoryNew != null){
            category.setId(categoryNew.getId());
            Category categoryObject = categoryService.save(category);
            return new ResponseEntity<>(categoryObject, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id) {
        Category categoryNew = categoryService.getById(id).get();
        if(categoryNew != null){
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
