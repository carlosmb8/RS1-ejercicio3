package com.example.rs1ejercicio3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    List<Persona> listadoPersonas;


    @PostMapping("persona/hola")
    public String grabaPersona(@RequestParam Integer id, String nombre, Integer edad, String poblacion) {
        if (id != null && nombre != null && edad != null && poblacion != null) {
            if (listadoPersonas.size() == 0) {
                Persona p = new Persona(id, nombre, edad, poblacion);
                listadoPersonas.add(p);
                System.out.println("grabando persona...");
                return "Persona insertada correctamente \n" + listadoPersonas.toString();

            } else {
                for (int i = 0; i < listadoPersonas.size(); i++) {
                    if (listadoPersonas.get(i).getId() != id) {

                        Persona p = new Persona(id, nombre, edad, poblacion);
                        listadoPersonas.add(p);
                        System.out.println("grabando persona...");
                        return "Persona insertada correctamente \n" + listadoPersonas.toString();
                    }

                    return "La id proporcionada ya pertenece a otra persona";
                }
            }
        }
        return "Hay campos sin rellenar";
    }

    @PutMapping("persona/{id}")
    public String editaPersona(@RequestParam Integer id, String nombre, Integer edad, String poblacion) {
        if (id != null && nombre != null && edad != null && poblacion != null) {
            for (int i = 0; i < listadoPersonas.size(); i++) {
                if (listadoPersonas.get(i).getId() == id) {
                    listadoPersonas.get(i).setNombre(nombre);
                    listadoPersonas.get(i).setEdad(edad);
                    listadoPersonas.get(i).setPoblacion(poblacion);

                    return "Persona editada correctamente. \n" + listadoPersonas.toString();
                }
                return "La id proporcionada no pertenece a ninguna persona.";
            }
        }
        return "Algunos campos no están rellenos";
    }


    @RequestMapping(value = "persona/{id}",method = RequestMethod.DELETE)
    public String borraPersona(@RequestParam Integer id) {
        if (id != null) {
            for (int i = 0; i < listadoPersonas.size(); i++) {
                if (listadoPersonas.get(i).getId() == id) {
                    listadoPersonas.remove(i);

                    return "Persona borrada correctamente. \n" + listadoPersonas.toString();
                }
            }
            return "La id proporcionada no pertenece a ninguna persona.";
        }
        return "Algunos campos no están rellenos";
    }

    @GetMapping("persona/{id}")
    public String muestraPersona(@RequestParam Integer id) {
        if (id != null) {
            for (int i = 0; i < listadoPersonas.size(); i++) {
                if (listadoPersonas.get(i).getId() == id) {

                    return "ID: " + listadoPersonas.get(i).getId() + " Nombre: " + listadoPersonas.get(i).getNombre() + " Edad: " + listadoPersonas.get(i).getEdad() + " Población: " + listadoPersonas.get(i).getPoblacion();
                }
                return "La id proporcionada no pertenece a ninguna persona.";
            }
        }
        return "Algunos campos no están rellenos";
    }
}
