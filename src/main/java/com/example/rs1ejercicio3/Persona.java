package com.example.rs1ejercicio3;

import lombok.Data;

import java.io.Serializable;

@Data
public class Persona implements Serializable {

    Integer id;
    String nombre;
    Integer edad;
    String poblacion;


    public Persona(Integer id, String nombre, Integer edad, String poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }

}
