package com.example.ecommerce.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Models.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, UUID> {

}
