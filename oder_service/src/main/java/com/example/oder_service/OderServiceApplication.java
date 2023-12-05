package com.example.oder_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication

@ComponentScan("com.example.oder_service.service")
@ComponentScan({"com.example.oder_service.controller", "com.example.oder_service.repository"})

public class OderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OderServiceApplication.class, args);
    }
}
