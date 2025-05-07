package com.example.ecommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Exceptions.ResourceNotFoundException;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Repository.ProductRepo;

import java.util.*;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public Product insertOne(Product newProd) {
		return repo.save(newProd);
	}
	
	public java.util.List<Product> getAllProducts(String search) {
		if(search != null && !search.isEmpty()) {
			return repo.findByNameOrBrandContainingIgnoreCase(search);
		}
		
		return repo.findAll();
	}
	
	public Product getProductById(UUID id) {
		return repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	}
}