package com.example.test.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.test.model.Category;
import com.example.test.model.Product;
import com.example.test.repository.categoryRepository;

@Service
public class categoryService {
	
@Autowired
private categoryRepository catrepository;
public List<Category> findAll(){
	return (List<Category>) catrepository.findAll();
	
}


public Optional<Category> findById(Integer id){
	return catrepository.findById(id);
}


public String deleteById(Integer id) {
	 catrepository.deleteById(id);
	 return "category deleted";
}


public Category addCategory(Category category) {
	
	return catrepository.save(category);
}



public ResponseEntity<Category> updateById(@RequestBody Category category,@PathVariable Integer id){
	Category oldCat=catrepository.findById(category.getId()).orElse(null);
	oldCat.setId(category.getId());
	oldCat.setCategoryName(category.getCategoryName());
	oldCat.setDescription(category.getDescription());
	
	Category newCat = new Category();
	newCat=catrepository.save(oldCat);
	return ResponseEntity.ok().body(newCat);
}


}
