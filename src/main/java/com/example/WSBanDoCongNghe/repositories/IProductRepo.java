package com.example.WSBanDoCongNghe.repositories;

import com.example.WSBanDoCongNghe.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends PagingAndSortingRepository<Product, Integer> {

}
