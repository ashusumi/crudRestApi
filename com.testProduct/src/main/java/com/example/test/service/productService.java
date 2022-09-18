package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.categoryRepository;
import com.example.test.repository.productRepository;
@Service
public class productService {
@Autowired
private productRepository proRepo;

@Autowired
private categoryRepository catRepo;

public Product addProduct(Product product,Category cat) {
	return proRepo.save(product);
}

public ResponseEntity<Product> updateById(@RequestBody Product product,@PathVariable Integer id){
	Product oldPro=proRepo.findById(product.getProductId()).orElse(null);
	oldPro.setProductId(product.getProductId());
	oldPro.setProductName(product.getProductName());
	oldPro.setProductDescription(product.getProductDescription());
	
	Product newPro = new Product();
	newPro=proRepo.save(oldPro);
	return ResponseEntity.ok().body(newPro);
}
}
