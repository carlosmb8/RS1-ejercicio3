package com.example.rs1ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Rs1Ejercicio3Application {

    public static void main(String[] args) {
        SpringApplication.run(Rs1Ejercicio3Application.class, args);
    }

    @Bean
    public List<Persona> grabaPerosna(){
        return new ArrayList<>();
    }
}
