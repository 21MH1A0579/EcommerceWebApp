package com.example.ecommerce.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Controller
public class ProductController {
	
	@Autowired
	ProductService newService;
	
	@PostMapping("/insert")
	@Operation(
			summary="Insert a new Product into DataBase."
			
			)
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product newProduct){
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
		
	}

}
