package com.stackpuz.example.repository;

import com.stackpuz.example.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    
}