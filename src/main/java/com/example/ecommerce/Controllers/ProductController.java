package com.example.ecommerce.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;

@Controller
public class ProductController {
	
	@Autowired
	ProductService newService;
	
	@PostMapping("/insert")
	@Operation(
			summary="Insert a new Product into DataBase."
			
			)
	public ResponseEntity<Product> createProduct(@org.springframework.web.bind.annotation.RequestBody Product newProduct){
		Product insertedProduct=newService.insertOne(newProduct);
		return new ResponseEntity<Product>(insertedProduct, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/products")
	@Operation(
			summary="Get All Products From DataBase."
			)
	public ResponseEntity<Product> getAllProducts(){
		java.util.List<Product> allProducts=newService.getAllProducts();
		return new ResponseEntity<Product>(allProducts.get(0),HttpStatus.FOUND);
	}

}
