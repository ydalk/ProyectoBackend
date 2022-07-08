package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Domicilio;
import com.example.ProyectoClinic.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    public Domicilio crearDomicilio(Domicilio domicilio) {

        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> leerDomicilio(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio modificarDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public List<Domicilio> getTodos() {

        List<Domicilio> domicilios = domicilioRepository.findAll();

        return domicilios;
    }
}
