package com.construction.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.construction")
@EnableJpaRepositories(basePackages = "com.construction.repositories")
@EntityScan(basePackages = "com.construction.entities")
public class ConstructionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionApplication.class, args);
	}

}
