package com.example.ElectronicCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = { "com.controller", "com.service" })
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.repo")
@EntityScan("com.model")
@EnableScheduling
public class ElectronicCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicCommerceApplication.class, args);
	}

}
