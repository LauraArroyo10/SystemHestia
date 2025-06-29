package com.SystemHestia.controller;


import com.SystemHestia.dto.TreatmentDTO;
import com.SystemHestia.model.Treatment;
import com.SystemHestia.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tratamientos")
public class TreatmentController {
    @Autowired
    private TreatmentService service;

    //get all
    @GetMapping
    public ResponseEntity<List<Treatment>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //get by id
    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        if (service.existsById(id)) {
            return ResponseEntity.ok(service.getTreatment(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra tratamiento");
    }


    //get by name
    @GetMapping("/paciente/{name}")
    public ResponseEntity<List<Treatment>> findByPatient(@PathVariable String name) {
        return ResponseEntity.ok(service.findByPatientName(name));
    }

    //add treatment
    @PostMapping
    public ResponseEntity<?> createTreatment(@RequestBody TreatmentDTO dto) {
        Optional<Treatment> newTreatment = service.addTreatment(dto);
        if (newTreatment.isPresent()) {
            return ResponseEntity.ok(newTreatment.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido generar tratamiento");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tratamiento eliminado exitosamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede eliminar algo que no existe");
    }




}//class end
