package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Domicilio;
import com.example.ProyectoClinic.modelo.Paciente;
import com.example.ProyectoClinic.modelo.Turno;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IDomicilioService domicilioService;
    @Autowired
    private ITurnoService turnoService;

    Domicilio domicilio1 = new Domicilio(1L,"Av Juares", "54", "Usaquen", "Bogota");
    Paciente pacientePedro = new Paciente(1L,"Monica", "Perez", "548762", new Date(), domicilio1);

    @Test
    public void testCrearPaciente(){

        domicilioService.crearDomicilio(domicilio1);
        pacienteService.crearPaciente(pacientePedro);

        Optional<Paciente> paciente = pacienteService.leerPaciente(2L);

        assertTrue(paciente != null);
        Assert.assertNotNull(pacienteService.leerPaciente(pacientePedro.getId()));
    }

    @Test
    public void testTraerTodos(){
        List<Paciente> pacientes = pacienteService.getTodos();
        assertTrue(!pacientes.isEmpty());
        assertTrue(pacientes.size()>=1);
    }

    @Test
    public void testEliminarPaciente(){


        Long idDomicilio =  pacientePedro.getDomicilio().getId();
        for (Turno turno : turnoService.getTodos()) {
            if( turno.getPaciente().getId() == pacientePedro.getId()){
                turnoService.eliminarTurno(turno.getId());
            }
        }
        pacienteService.eliminarPaciente(1L);
        domicilioService.eliminarDomicilio(idDomicilio);

        assertTrue(pacienteService.leerPaciente(1L).isEmpty());
    }

}