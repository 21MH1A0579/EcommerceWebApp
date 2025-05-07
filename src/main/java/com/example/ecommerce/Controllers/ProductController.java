package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService newService;

    @PostMapping("/insert")
    @Operation(summary = "Insert a new Product into DataBase.")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        Product insertedProduct = newService.insertOne(newProduct);
        return new ResponseEntity<>(insertedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    @Operation(summary = "Get All Products From DataBase.")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = newService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}
