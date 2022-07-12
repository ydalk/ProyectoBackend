package com.example.ProyectoClinic.controller;

import com.example.ProyectoClinic.modelo.Odontologo;
import com.example.ProyectoClinic.service.OdontologoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    final static Logger log = Logger.getLogger(OdontologoController.class);

    @PostMapping("/nuevo")
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        log.debug("Registrando un nuevo odontologo : "+ odontologo.toString());

        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        log.debug("Consultando el odontologo : "+ id );

        Odontologo odontologo = odontologoService.leerOdontologo(id).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        log.debug("Actualizando un odontologo : "+ odontologo.toString());

        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.leerOdontologo(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.modificarOdontologo(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Eliminando el odontologo : "+ id);

        ResponseEntity<String> response = null;

        if (odontologoService.leerOdontologo(id).isPresent()) {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Odontologo Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        log.debug("Listando los odontologos" );

        return ResponseEntity.ok(odontologoService.getTodos());
    }

}
