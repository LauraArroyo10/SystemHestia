package com.SystemHestia.service;

import com.SystemHestia.dto.TreatmentDTO;
import com.SystemHestia.model.*;
import com.SystemHestia.repository.DiseaseRepositoryJPA;
import com.SystemHestia.repository.MedicineRepositoryJPA;
import com.SystemHestia.repository.PatientRepositoryJPA;
import com.SystemHestia.repository.TreatmenRepositoryJPA;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {
    @Autowired
    private TreatmenRepositoryJPA repository;

    @Autowired
    private PatientRepositoryJPA patientRepository;
    @Autowired
    private MedicineRepositoryJPA medicineRepository;
    @Autowired
    DiseaseRepositoryJPA diseaseRepository;



    //find all
    public List<Treatment> findAll(){
        return repository.findAll();
    }


    //find by patient
    public List<Treatment> findByPatientName(String name) {
        return repository.findByPatientName(name);
    }

    //save/add
    public Optional<Treatment> addTreatment(TreatmentDTO dto) {
        Treatment treatment = new Treatment();

        Patient patient = patientRepository.findById(dto.getPatient().getId()).orElse(null);
        if (patient == null) return Optional.empty();
        treatment.setPatient(patient);

        Medicine medicine = medicineRepository.findById(dto.getMedicine().getId()).orElse(null);
        if (medicine == null) return Optional.empty();
        treatment.setMedicine(medicine);

        Disease disease = diseaseRepository.findById(dto.getDisease().getId()).orElse(null);
        if (disease == null) return Optional.empty();
        treatment.setDisease(disease);

        treatment.setDosage(dto.getDosage());
        treatment.setFrequency(dto.getFrequency());
        treatment.setStartDate(dto.getStartDate());
        treatment.setEndDate(dto.getEndDate());
        treatment.setStatus(dto.getStatus());

        if (dto.getObservations() == null || dto.getObservations().isBlank()) {
            treatment.setObservations("Observacion no registrada. Se recomienda seguimiento clinico.");
        } else {
            treatment.setObservations(dto.getObservations());
        }
        return Optional.of(repository.save(treatment));
    }



    //delete by id
    public Optional<Treatment> deleteById(Integer id) {
        Optional<Treatment> treatmentOptional = repository.findById(id);

        if (treatmentOptional.isPresent()) {
            Treatment treatment = treatmentOptional.get();
            repository.delete(treatment);
            return Optional.of(treatment);
        }
        return Optional.empty();
    }


    //edit


    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
    public Treatment getTreatment(Integer id) {
        Optional<Treatment> treatment = repository.findById(id);
        if (treatment.isPresent()) {
            return treatment.get();
        }
        return new Treatment();
    }
}
