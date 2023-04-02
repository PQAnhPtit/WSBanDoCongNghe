package com.example.WSBanDoCongNghe.services;

import com.example.WSBanDoCongNghe.model.User;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserService {
    ArrayList<User> getAll();
    Optional<User> getById(int id);
    User save(User User);
    void delete(int id);
}
