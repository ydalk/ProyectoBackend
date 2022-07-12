package com.example.ProyectoClinic.controller;

import com.example.ProyectoClinic.modelo.Paciente;
import com.example.ProyectoClinic.service.IDomicilioService;
import com.example.ProyectoClinic.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IDomicilioService domicilioService;

    final static Logger log = Logger.getLogger(PacienteController.class);

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrarPaciente(@RequestBody Paciente paciente) {
        log.debug("Registrando un nuevo paciente : "+ paciente.toString());

        domicilioService.crearDomicilio(paciente.getDomicilio());
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        log.debug("Consultando el paciente : "+ id);

        Paciente paciente = pacienteService.leerPaciente(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        log.debug("Actualizando un paciente : "+ paciente.toString());

        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.leerPaciente(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        log.debug("Eliminando un paciente : "+ id);

        ResponseEntity<String> response = null;

        if (pacienteService.leerPaciente(id).isPresent()) {

            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Paciente Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        log.debug("Listando los pacientes ");

        return ResponseEntity.ok(pacienteService.getTodos());
    }
}
