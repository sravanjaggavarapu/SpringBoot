package com.pack.springboot;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;

	public void save(Product product) {
		repository.save(product);		
	}

	public List<Product> getDetails() {
		return repository.findAll();
	}

	public void delete(Long id) {
		repository.deleteById(id);		
	}

	public Product get(Long id) {
		return  repository.findById(id).get();
	}
}