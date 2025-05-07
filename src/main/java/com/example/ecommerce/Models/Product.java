package com.example.ecommerce.Models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	     @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;

	    @NotBlank(message = "Product name is required")
	    @Column(nullable = false)
	    private String name;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    @NotNull(message = "Price is required")
	    @Positive(message = "Price must be positive")
	    private BigDecimal price;

	    private String brand;

	    @Enumerated(EnumType.STRING)
	    private ProductCategory category;

	    private String imageUrl;

	    public enum ProductCategory {
	        ELECTRONICS,
	        FASHION,
	        BOOKS,
	        HOME_APPLIANCES,
	        BEAUTY,
	        SPORTS,
	        TOYS,
	        FURNITURE,
	        GROCERY
	    }

	   
}
