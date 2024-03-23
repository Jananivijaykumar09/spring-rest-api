package com.c2c.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.c2c.dynamo.repositories.ProductRepository;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackageClasses = ProductRepository.class)

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
