package com.example.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.Category;
import com.example.test.model.Product;


public interface categoryRepository extends CrudRepository<Category, Integer>{

	List<Category> save(Integer id);

	

	


	

}
 