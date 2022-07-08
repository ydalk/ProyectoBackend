package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    Odontologo odontologo1 = new Odontologo("Carolina", "Porras", 23564);

    @Test
    public void testCrearOdontologo(){

        odontologoService.crearOdontologo(odontologo1);

        Optional<Odontologo> odontologoCarolina = odontologoService.leerOdontologo(1L);

        assertTrue(odontologoCarolina != null);
    }

    @Test
    public void testTraerTodos() {
        List<Odontologo> odontologos = odontologoService.getTodos();
        assertTrue(!odontologos.isEmpty());
        assertTrue(odontologos.size() >= 1);
        System.out.println(odontologos);
    }

    @Test
    public void testEliminasOdontologo(){
        odontologoService.eliminarOdontologo(2L);
        assertTrue(odontologoService.leerOdontologo(2L).isEmpty());
    }

}