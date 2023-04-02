package com.example.WSBanDoCongNghe.repositories;

import com.example.WSBanDoCongNghe.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends PagingAndSortingRepository<Category, Integer> {

}
