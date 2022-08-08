package com.project.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.project.*")
@EnableJpaRepositories("com.project.repo")
@EntityScan("com.project.entities")
public class EntitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntitiesApplication.class, args);
	}

}
