package com.example.WSBanDoCongNghe.repositories;

import com.example.WSBanDoCongNghe.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends PagingAndSortingRepository<Order, Integer> {

}
