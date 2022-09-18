package com.example.test.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.categoryRepository;
import com.example.test.service.categoryService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class CategoryController {

	@Autowired
	private categoryService catService;
	
	@Autowired
	categoryRepository catRepo;
	
	@GetMapping("/api/categories")
	public List<Category> findAll(){
		return catService.findAll();
	}
	
	@GetMapping("/api/categories/{id}")
	public Optional<Category> findByid(@PathVariable("id")Integer id){
		return catService.findById(id);
	}
	
	@DeleteMapping("/api/deleteCategories/{id}")
	public String deleteCategory(@PathVariable ("id") Integer id) {
	  catService.deleteById(id);
	 return "deleted category"+id;
	}
	
	@PostMapping("/api/addCategories")
	public Category addCat(@RequestBody Category cat) {
		
		return catService.addCategory(cat);
	}
	
	@PutMapping("/api/updateCategories/{id}")
	public ResponseEntity<Category> updateCat(@RequestBody Category category,@PathVariable("id")Integer id) {
		return catService.updateById(category, id);
	}
	
}					