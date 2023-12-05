package com.example.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
//@EntityScan(basePackages = "com.example.mini_project.model")
//@EntityScan
@ComponentScan("com.example.mini_project.service")
@ComponentScan({"com.example.mini_project.controller", "com.example.mini_project.repository"})
//@EnableJpaRepositories("com.example.mini_project.repository")

public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
