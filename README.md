# E-commerce Search Backend

This repository contains the backend service for an E-commerce product search application built with Spring Boot.

## Overview

The backend provides REST APIs to:
- Search and list products with filtering capabilities
- Retrieve detailed product information by ID
- Pre-load sample product data

## Technologies Used

- Java 17
- Spring Boot 3.1.x
- Spring Data JPA
- H2 Database (in-memory)
- Swagger/OpenAPI for API documentation
- Maven for dependency management and build

## API Endpoints

| Method | URL                  | Description                                      |
|--------|----------------------|--------------------------------------------------|
| GET    | /products            | List all products (with optional search parameter)|
| GET    | /products?search=xyz | Search products by name or brand                 |
| GET    | /products/{id}       | Get detailed information about a specific product|

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/ecommerce-search-backend.git
cd ecommerce-search-backend
```

2. Build the application:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`.

## Database Configuration

By default, the application uses an H2 in-memory database. Sample product data is automatically loaded via data.sql on startup.

To use PostgreSQL instead (optional):

1. Uncomment the PostgreSQL configuration in `application.properties`
2. Update the database credentials in `application.properties`
3. Add PostgreSQL dependency in `pom.xml`

## API Documentation

Once the application is running, access the Swagger UI documentation at:
```
http://localhost:8080/swagger-ui.html
```

## Data Model

### Product Entity

| Field       | Type        | Description                                 |
|-------------|-------------|---------------------------------------------|
| id          | UUID        | Auto-generated unique identifier            |
| name        | String      | Product name (mandatory)                    |
| description | String      | Detailed product description                |
| price       | BigDecimal  | Product price                               |
| brand       | String      | Product brand name                          |
| category    | Enum        | Product category (e.g., Electronics, Fashion)|
| imageUrl    | String      | URL to product image                        |

## Project Structure

```
src/
├── main/
│   ├── java/com/example/ecommerce/
│   │   ├── config/
│   │   │   └── SwaggerConfig.java
│   │   ├── controller/
│   │   │   └── ProductController.java
│   │   ├── model/
│   │   │   ├── Product.java
│   │   │   └── Category.java
│   │   ├── repository/
│   │   │   └── ProductRepository.java
│   │   ├── service/
│   │   │   ├── ProductService.java
│   │   │   └── ProductServiceImpl.java
│   │   └── EcommerceApplication.java
│   └── resources/
│       ├── data.sql           # Sample data loading script
│       └── application.properties
└── test/
    └── java/com/example/ecommerce/
        ├── controller/
        │   └── ProductControllerTest.java
        └── service/
            └── ProductServiceTest.java
```

## Running Tests

Execute the following command to run the tests:

```bash
mvn test
```

## Integration with Frontend

This backend is designed to work with the React frontend application. The frontend connects to this backend via the REST APIs described above.

## Error Handling

The API implements proper error handling with appropriate HTTP status codes and error messages.

## Future Improvements

- Implement pagination for product listings
- Add sorting functionality
- Enhance search with more advanced filtering options
- Implement product ratings and reviews
- Add authentication and user management

## License

[MIT License](LICENSE)
