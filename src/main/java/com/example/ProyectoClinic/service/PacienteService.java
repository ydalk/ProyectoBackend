package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Paciente;
import com.example.ProyectoClinic.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public Paciente crearPaciente(Paciente paciente) {

        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> leerPaciente(Long id) {

        return pacienteRepository.findById(id);

    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {

        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<Paciente> getTodos() {

        List<Paciente> pacientes = pacienteRepository.findAll();

        return pacientes;
    }
}
