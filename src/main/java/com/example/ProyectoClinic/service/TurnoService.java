package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Turno;
import com.example.ProyectoClinic.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public Turno crearTurno(Turno turno) {

        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> leerTurno(Long id) {

        Optional<Turno> turno = turnoRepository.findById(id);

        return turno;
    }

    @Override
    public Turno modificarTurno(Turno turno) {

        return turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {

        turnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> getTodos() {

        List<Turno> turnos = turnoRepository.findAll();

        return (List<Turno>) turnos;
    }
}
