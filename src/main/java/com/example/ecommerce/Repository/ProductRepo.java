package com.example.ecommerce.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Models.Product;

public interface ProductRepo extends JpaRepository<Product, UUID> {

}
