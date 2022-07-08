package com.example.ProyectoClinic.service;


import com.example.ProyectoClinic.modelo.Turno;

import java.util.List;
import java.util.Optional;


public interface ITurnoService {

    Turno crearTurno(Turno turno);
    Optional<Turno> leerTurno(Long id);
    Turno modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    List<Turno> getTodos();
}
