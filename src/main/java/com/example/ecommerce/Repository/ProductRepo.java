package com.example.ecommerce.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.Models.Product;

public interface ProductRepo extends JpaRepository<Product, UUID> {

	@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Product> findByNameOrBrandContainingIgnoreCase(@Param("search") String search);
}
