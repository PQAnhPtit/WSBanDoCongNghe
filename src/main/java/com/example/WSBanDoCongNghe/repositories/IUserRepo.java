package com.example.WSBanDoCongNghe.repositories;

import com.example.WSBanDoCongNghe.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends PagingAndSortingRepository<User, Integer> {

}
