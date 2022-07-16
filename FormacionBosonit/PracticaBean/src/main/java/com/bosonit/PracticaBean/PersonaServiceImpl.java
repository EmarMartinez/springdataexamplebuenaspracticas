package com.bosonit.PracticaBean;

import org.springframework.stereotype.Service;


public class PersonaServiceImpl implements PersonaService{


    Persona person = new Persona();

    @Override
    public void setNombre(String nombre) {
        person.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return person.getNombre();
    }
}

