package com.example.test.controller;



import java.util.List;
import java.util.Optional;

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
import com.example.test.repository.productRepository;
import com.example.test.service.categoryService;
import com.example.test.service.productService;

@RestController
public class productController {
	@Autowired
	private categoryRepository catRepo;
	
	@Autowired
	productService proService;
	
	@Autowired 
	private categoryService service;
	
	@Autowired
	productRepository proRepo;
	
	@GetMapping("/api/products")
	public List<Product> getAllProduct() {
		return (List<Product>) proRepo.findAll();
	}
	@GetMapping("/api/products/{id}")
	public Optional<Product> getProductById(@PathVariable ("id")Integer id){
		return proRepo.findById(id);
		
	}
	
	@PostMapping("/api/Products")
	public Product getProduct(@RequestBody Product product) {
		return proRepo.save(product);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public String deleteBYId(@PathVariable ("id") Integer id) {
		proRepo.deleteById(id);
		return "deleted";
	}
	@PutMapping("/api/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id")Integer id){
		return proService.updateById(product, id);
	}

}
