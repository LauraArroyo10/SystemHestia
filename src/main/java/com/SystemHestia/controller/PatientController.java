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



//GET ALL BY ID
@GetMapping ("{id}")
    public Patient get(@PathVariable int id){
    return service.findById(id);
}


//POST
    @PostMapping
    public Patient post(@RequestBody Patient patient){
    return service.add(patient);}


//PUT
    @PutMapping
    public Patient put(@RequestBody Patient patient){
    return service.update(patient);
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
    return ResponseEntity.ok(service.edit(patient));
}

}//class end
