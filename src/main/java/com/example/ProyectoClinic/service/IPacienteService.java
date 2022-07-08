package com.example.ProyectoClinic.service;


import com.example.ProyectoClinic.modelo.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    Paciente crearPaciente(Paciente paciente);

    Optional<Paciente> leerPaciente(Long id);

    Paciente modificarPaciente(Paciente paciente);

    void eliminarPaciente(Long id);

    List<Paciente> getTodos();
}
