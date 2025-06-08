package com.SystemHestia.service;

import com.SystemHestia.model.Medication;

import com.SystemHestia.repository.MedicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MedicationService {

    @Autowired
    MedicationRepository repository;


    // GET ALL
    public ArrayList<Medication> getAll(){
        return repository.getAll();
    }
    //GET SPACE BY ID
    public Medication findById(Integer id){return repository.findById(id);}
    //POST SPACE
    public Medication add(Medication medication){
        return repository.add(medication);
    }
    //PUT SPACE
    public Medication update (Medication medication){
        return repository.update(medication);
    }
    //DELETE SPACE
//    public Medication delete(Medication id){
//        return repository.delete(id);
//    }
    //PATCH SPACE
    public Medication  edit (Medication medication){return repository.edit(medication);}


}
