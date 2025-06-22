package com.SystemHestia.repository;

import com.SystemHestia.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoryJPA extends JpaRepository<Patient,Integer> {

    boolean existsByName(String name );
    Patient findByName(String name);

}
