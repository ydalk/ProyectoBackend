package com.example.ProyectoClinic.service;

import com.example.ProyectoClinic.modelo.Odontologo;
import com.example.ProyectoClinic.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {

        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> leerOdontologo(Long id) {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);

        return odontologo;
    }

    @Override
    public Odontologo modificarOdontologo(Odontologo odontologo) {

        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {

        odontologoRepository.deleteById(id);

    }

    @Override
    public List<Odontologo> getTodos() {

        return odontologoRepository.findAll();
    }
}
