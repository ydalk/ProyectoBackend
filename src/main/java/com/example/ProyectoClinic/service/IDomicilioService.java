package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Domicilio;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {

    Domicilio crearDomicilio(Domicilio domicilio);

    Optional<Domicilio> leerDomicilio(Long id);

    Domicilio modificarDomicilio(Domicilio domicilio);

    void eliminarDomicilio(Long id);

    List<Domicilio> getTodos();
}
