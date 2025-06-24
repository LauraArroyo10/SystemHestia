package com.SystemHestia.controller;

import com.SystemHestia.model.Patient;
import com.SystemHestia.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

@Autowired
    private PatientService service;

//GET ALL
@GetMapping
public ResponseEntity<List<Patient>> getAll() {
    List<Patient> patients = service.getAll();
    if (patients.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());
    }
    return ResponseEntity.ok(patients);
}




//GET PACIENT BY ID
@GetMapping ("{id}")
    public ResponseEntity<?> get(@PathVariable int id){
    if (service.existsById(id)){
        return ResponseEntity.ok(service.findById(id));
    }
    return ResponseEntity.notFound().build();
}


//POST
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Patient patient){
    Patient create = service.add(patient);
    if (create!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hubo un problema y no se pudo crear el paciente");
}


//PUT
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Patient patient){
    if (service.existsById(patient.getId())){
        return ResponseEntity.ok(service.update(patient));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id no se encuentra registrado");
    }


//DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


//PATCH
@PatchMapping
public ResponseEntity<?> patch (@RequestBody Patient patient) {
    if (service.existsById(patient.getId())){
       return ResponseEntity.ok(service.edit(patient));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id no está registrado");
}

}//class end
