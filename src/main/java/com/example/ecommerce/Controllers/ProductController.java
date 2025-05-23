package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product API", description = "Operations for e-commerce products")
@CrossOrigin(origins = "*") 
public class ProductController {

    @Autowired
    ProductService newService;

    @PostMapping("/insert")
    @Operation(summary = "Insert a new Product into DataBase.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New Product Inserted SuccessFully.",
                         content = @Content(schema = @Schema(implementation = Product.class)))
        })
    public ResponseEntity<List<Product>> createProduct(@RequestBody List<Product> newProducts) {
        List<Product> insertedProducts = newService.insertProducts(newProducts);
        return new ResponseEntity<>(insertedProducts, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all products or search by name/brand")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products found",
                     content = @Content(schema = @Schema(implementation = Product.class)))
    })
    public ResponseEntity<List<Product>> getAllProducts(  @Parameter(description = "Search term for product name or brand")@RequestParam(required=false) String search) {
        List<Product> allProducts = newService.getAllProducts(search);
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found",
                     content = @Content(schema = @Schema(implementation = Product.class))),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<Product> getProductById(
            @Parameter(description = "Product ID", required = true)
            @PathVariable UUID id){
       Product product =newService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
