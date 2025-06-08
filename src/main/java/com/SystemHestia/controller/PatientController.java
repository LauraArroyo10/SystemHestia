package com.SystemHestia.controller;

import com.SystemHestia.model.Patient;
import com.SystemHestia.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/patients")
public class PatientController {

@Autowired
    PatientService service;

//GET ALL
@GetMapping
public ArrayList<Patient>getAll(){
    return service.getAll();
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
    public Patient delete(@PathVariable int id){
    return service.delete(id);
    }
//PATCH
@PatchMapping
public Patient patchSpace (@RequestBody Patient patient) {

    return service.edit(patient);
}


}
