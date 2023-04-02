package com.example.WSBanDoCongNghe.controllers;

import com.example.WSBanDoCongNghe.model.Order;
import com.example.WSBanDoCongNghe.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService OrderService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Order>> getAllOrder() {
        return new ResponseEntity<>(OrderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Order> add(@RequestBody Order Order){
        return new ResponseEntity<>(OrderService.save(Order), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> edit(@PathVariable int id){
        Order Order = OrderService.getById(id).get();
        if(Order != null){
            return new ResponseEntity<>(Order, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        Optional<Order> OrderOptional = OrderService.getById(id);
        return OrderOptional.map(Order -> new ResponseEntity<>(Order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> doEdit(@PathVariable("id") int id, @RequestBody Order Order) {
        Order OrderNew = OrderService.getById(id).get();
        if(OrderNew != null){
            Order.setId(OrderNew.getId());
            Order OrderObject = OrderService.save(Order);
            return new ResponseEntity<>(OrderObject, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable int id) {
        Order OrderNew = OrderService.getById(id).get();
        if(OrderNew != null){
            OrderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
