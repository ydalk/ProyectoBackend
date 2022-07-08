package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Domicilio;
import com.example.ProyectoClinic.modelo.Odontologo;
import com.example.ProyectoClinic.modelo.Paciente;
import com.example.ProyectoClinic.modelo.Turno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;
    @Autowired
    private IDomicilioService domicilioService;


    @Test
    public void testCrearTurno(){

        Domicilio domicilioAna = new Domicilio("Av Suba", "134", "suba", "bogota");
        domicilioService.crearDomicilio(domicilioAna);
        Paciente pacienteAna = pacienteService.crearPaciente(new Paciente("Ana", "Linares", "fyu236", new Date(),domicilioAna));
        Odontologo odontologoJuan = odontologoService.crearOdontologo(new Odontologo("Juan", "Perez", 2456));

        turnoService.crearTurno(new Turno(new Date(), pacienteAna, odontologoJuan));

        assertNotNull(turnoService.leerTurno(1L));
    }

    @Test
    public void testTraerTodos(){
        List<Turno> turnos = turnoService.getTodos();
        assertTrue(!turnos.isEmpty());
        assertTrue(turnos.size()>=1);
    }

    @Test
    public void testEliminarTurno(){

        turnoService.eliminarTurno(4L);
        assertTrue(turnoService.leerTurno(4L).isEmpty());

    }

}