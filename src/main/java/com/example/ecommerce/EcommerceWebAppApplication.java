package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition( 
		info=@Info(
				title="EcommorceWebApp-BackEnd",
				version="1.0",
				description="DEVELOPED BY BRAHMENDRA",
				contact=@Contact(name="CHALUMURI BRAHMENDRA",email="chalumuribrahmendra@gmail.com")
				)  
		)
public class EcommerceWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebAppApplication.class, args);
	}

}
