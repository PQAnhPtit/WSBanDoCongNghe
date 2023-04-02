package com.example.WSBanDoCongNghe.services.impl;

import com.example.WSBanDoCongNghe.model.User;
import com.example.WSBanDoCongNghe.repositories.IUserRepo;
import com.example.WSBanDoCongNghe.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo UserRepo;

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> list = new ArrayList<>();
        Iterable it = UserRepo.findAll();
        for(Object User: it){
            list.add((User) User);
        }
        return list;
    }

    @Override
    public Optional<User> getById(int id) {
        return UserRepo.findById(id);
    }

    @Override
    public User save(User User) {
        return UserRepo.save(User);
    }

    @Override
    public void delete(int id) {
        UserRepo.deleteById(id);
    }
}
