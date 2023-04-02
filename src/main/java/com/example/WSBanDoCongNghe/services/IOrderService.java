package com.example.WSBanDoCongNghe.services;

import com.example.WSBanDoCongNghe.model.Order;

import java.util.ArrayList;
import java.util.Optional;

public interface IOrderService {
    ArrayList<Order> getAll();
    Optional<Order> getById(int id);
    Order save(Order Order);
    void delete(int id);
}
