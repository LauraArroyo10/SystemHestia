package com.SystemHestia.repository;
import com.SystemHestia.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepositoryJPA extends JpaRepository<Medicine, Integer> {

    boolean existsByName(String name );
    Medicine findByName(String name);
}
