package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "E-commerce API",
	        version = "1.0",
	        description = "REST API for E-commerce Product Search and Details",
	        contact = @Contact(name = "chalumuri Brahmendra", email = "chalumuribrahmendra@gmail.com")
	    ),
	    servers = {
	        @Server(url = "http://localhost:8085", description = "Local Development Server")
	    }
	)
public class EcommerceWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebAppApplication.class, args);
	}

}
