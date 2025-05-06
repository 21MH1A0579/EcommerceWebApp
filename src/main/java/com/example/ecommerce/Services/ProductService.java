package com.example.ecommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo repo;
	
	public Product insertOne(Product newProd) {
		
		return repo.save(newProd);
	}

}
