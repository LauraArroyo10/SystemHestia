package com.SystemHestia.service;

import com.SystemHestia.model.Disease;
import com.SystemHestia.model.Patient;
import com.SystemHestia.repository.DiseaseRepositoryJPA;
import com.SystemHestia.repository.PatientRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepositoryJPA repository;
    @Autowired
    private DiseaseRepositoryJPA diseaseRepositoryJPA;

    //GET ALL
    public List<Patient> getAll() {
        return repository.findAll();
    }



    //GET BY ID
    public Patient findById(Integer id) {
        Optional<Patient> patient = repository.findById(id);
        if (patient.isEmpty()) {
            throw new RuntimeException("Paciente no encontrado");
        }
        return patient.get();
    }

    //POST
//    public Patient add(Patient patient) {
//        return repository.save(patient);
//    }


    public Patient add(Patient patient) {
        if (patient.getPrimaryDisease() != null) {
            Optional<Disease> optionalDisease = diseaseRepositoryJPA.findById(patient.getPrimaryDisease().getId());
            if (!optionalDisease.isPresent()) {
                throw new RuntimeException("La enfermedad no existe en la base de datos.");
            }
            patient.setPrimaryDisease(optionalDisease.get());
        }
        return repository.save(patient);
    }


    public Patient edit(Patient patient) {
        Patient element = getPatient(patient.getId());

        if (element != null && element.getId().equals(patient.getId())) {
            if (patient.getName() != null) {
                element.setName(patient.getName());
            }
            if (patient.getAge() != null) {
                element.setAge(patient.getAge());
            }
            if (patient.getAllergies() != null) {
                element.setAllergies(patient.getAllergies());
            }
            if (patient.getConditions() != null) {
                element.setConditions(patient.getConditions());
            }
            if (patient.getPrimaryDisease() != null) {
                element.setPrimaryDisease(patient.getPrimaryDisease());
            }
            if (patient.getId() != null) {
                element.setId(patient.getId());
            }
            if (patient.getRole() != null) {
                element.setRole(patient.getRole());
            }
            return repository.save(element);
        }
        return null;
    }

    //DELETE
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public Patient update(Patient patient) {
        return repository.save(patient);
    }


    // VALIDACIONES
    public boolean existByName(String name) {
        return repository.existsByName(name);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    // BÚSQUEDAS ADICIONALES
    public Patient getByName(String name) {
        return repository.findByName(name);
    }

    public Patient getPatient(Integer id) {
        Optional<Patient> patient = repository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        }
        return new Patient();
    }

}//class end



