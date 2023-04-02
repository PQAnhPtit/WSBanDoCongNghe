package com.example.WSBanDoCongNghe.controllers;

import com.example.WSBanDoCongNghe.model.Product;
import com.example.WSBanDoCongNghe.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService ProductService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Product>> getAllProduct() {
        return new ResponseEntity<>(ProductService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> add(@RequestBody Product Product){
        return new ResponseEntity<>(ProductService.save(Product), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable int id){
        Product Product = ProductService.getById(id).get();
        if(Product != null){
            return new ResponseEntity<>(Product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Optional<Product> ProductOptional = ProductService.getById(id);
        return ProductOptional.map(Product -> new ResponseEntity<>(Product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> doEdit(@PathVariable("id") int id, @RequestBody Product Product) {
        Product ProductNew = ProductService.getById(id).get();
        if(ProductNew != null){
            Product.setId(ProductNew.getId());
            Product ProductObject = ProductService.save(Product);
            return new ResponseEntity<>(ProductObject, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        Product ProductNew = ProductService.getById(id).get();
        if(ProductNew != null){
            ProductService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
