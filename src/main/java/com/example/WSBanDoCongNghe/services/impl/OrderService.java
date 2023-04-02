package com.example.WSBanDoCongNghe.services.impl;

import com.example.WSBanDoCongNghe.model.Order;
import com.example.WSBanDoCongNghe.repositories.IOrderRepo;
import com.example.WSBanDoCongNghe.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepo OrderRepo;

    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> list = new ArrayList<>();
        Iterable it = OrderRepo.findAll();
        for(Object Order: it){
            list.add((Order) Order);
        }
        return list;
    }

    @Override
    public Optional<Order> getById(int id) {
        return OrderRepo.findById(id);
    }

    @Override
    public Order save(Order Order) {
        Order.setCreated_date(new Date());
        return OrderRepo.save(Order);
    }

    @Override
    public void delete(int id) {
        OrderRepo.deleteById(id);
    }
}
