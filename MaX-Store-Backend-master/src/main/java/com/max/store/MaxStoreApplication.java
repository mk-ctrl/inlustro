package com.max.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(
		info =@Info(
				title = "MaX Store",
				version = "0.0.3",
				description = "Ecommerce Project",
				contact = @Contact(
						name = "MaX",
						email = "max.neo.dev@gmail.com"
						)
				)
		)

public class MaxStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaxStoreApplication.class, args);
	}

}
