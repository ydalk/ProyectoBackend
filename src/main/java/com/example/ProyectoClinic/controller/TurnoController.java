package com.example.ProyectoClinic.controller;

import com.example.ProyectoClinic.modelo.Turno;
import com.example.ProyectoClinic.service.OdontologoService;
import com.example.ProyectoClinic.service.PacienteService;
import com.example.ProyectoClinic.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    final static Logger log = Logger.getLogger(TurnoController.class);

    @PostMapping("/nuevo")
    public ResponseEntity<Turno> registarTurno(@RequestBody Turno turno){
        log.debug("Registrando un nuevo turno : "+ turno.toString());

        ResponseEntity<Turno> response;
        if(pacienteService.leerPaciente(turno.getPaciente().getId()).isPresent() && odontologoService.leerOdontologo(turno.getOdontologo().getId()).isPresent()){
            response = ResponseEntity.ok(turnoService.crearTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id){
        log.debug("Buscando el turno : "+ id);

        Turno turno = turnoService.leerTurno(id).orElse(null);

        return ResponseEntity.ok(turno);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno){
        log.debug("Actualizando el turno : "+ turno.toString());

        ResponseEntity<Turno> response = null;

        if(turno.getId() != null && turnoService.leerTurno(turno.getId()).isPresent()){
            response = ResponseEntity.ok(turnoService.modificarTurno(turno));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar( @PathVariable Long id){
            log.debug("Eliminando el turno : "+ id);

            ResponseEntity<String> response = null;

            if(turnoService.leerTurno(id).isPresent()){
                turnoService.eliminarTurno(id);
                response = ResponseEntity.status(HttpStatus.OK).body("Turno Eliminado");
            }else{
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return response;
        }

        @GetMapping
        public ResponseEntity<List<Turno>>buscarTodos(){
            log.debug("Listando los turnos ");

            return ResponseEntity.ok(turnoService.getTodos());
        }


}
