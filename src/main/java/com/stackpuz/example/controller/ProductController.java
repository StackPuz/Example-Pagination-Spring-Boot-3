package com.stackpuz.example.controller;

import java.util.Optional;
import com.stackpuz.example.entity.Product;
import com.stackpuz.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/api/products")
    public List<Product> getProducts(@RequestParam("page") Optional<Integer> pageParam, @RequestParam("size") Optional<Integer> sizeParam, @RequestParam("order") Optional<String> orderParam, @RequestParam("direction") Optional<String> directionParam) {
        int page = pageParam.orElse(1) - 1;
        int size = sizeParam.orElse(10);
        String order = orderParam.orElse("id");
        String direction = directionParam.orElse("asc");
        return repository.findAll(PageRequest.of(page, size, Sort.by(Direction.fromString(direction), order))).getContent();
    }
}