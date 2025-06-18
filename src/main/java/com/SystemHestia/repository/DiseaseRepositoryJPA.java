package com.SystemHestia.repository;


import com.SystemHestia.model.Disease;
import com.SystemHestia.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepositoryJPA extends JpaRepository<Disease,Integer> {
    boolean existsByName(String name );
    Disease findByName(String name);

}
