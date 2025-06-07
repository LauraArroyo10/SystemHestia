package com.SystemHestia.service;

import com.SystemHestia.model.Patient;
import com.SystemHestia.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PatientService {

    @Autowired
    PatientRepository repository;


    // GET ALL
    public ArrayList<Patient> getAll(){
        return repository.getAll();
    }
    //GET SPACE BY ID
    public Patient findById(Integer id){
        return repository.findById(id);}
    //POST SPACE
    public Patient add(Patient patient){
        return repository.add(patient);
    }
    //PUT SPACE
    public Patient update (Patient patient){
        return repository.update(patient);
    }
    //DELETE SPACE
    public Patient delete(Integer id){
        return repository.delete(id);
    }

}
