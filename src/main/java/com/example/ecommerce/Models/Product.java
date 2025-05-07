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

@Entity
@Table
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

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public ProductCategory getCategory() {
			return category;
		}

		public void setCategory(ProductCategory category) {
			this.category = category;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Product(UUID id, @NotBlank(message = "Product name is required") String name, String description,
				@NotNull(message = "Price is required") @Positive(message = "Price must be positive") BigDecimal price,
				String brand, ProductCategory category, String imageUrl) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.brand = brand;
			this.category = category;
			this.imageUrl = imageUrl;
		}

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", brand=" + brand + ", category=" + category + ", imageUrl=" + imageUrl + "]";
		}
	    

}
