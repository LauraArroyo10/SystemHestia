package com.SystemHestia.repository;

import com.SystemHestia.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmenRepositoryJPA extends JpaRepository<Treatment,Integer> {

    List<Treatment> findByPatientName(String name);
    boolean existsById(Integer id);


}
