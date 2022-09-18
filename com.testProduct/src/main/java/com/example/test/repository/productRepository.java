package com.example.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Product;

@Repository
public interface productRepository extends CrudRepository<Product, Integer>{

}
