package com.example.ProyectoClinic.service;


import com.example.ProyectoClinic.modelo.Odontologo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {

    Odontologo crearOdontologo(Odontologo odontologo);
    Optional<Odontologo> leerOdontologo(Long id);
    Odontologo modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    List<Odontologo> getTodos();

}
