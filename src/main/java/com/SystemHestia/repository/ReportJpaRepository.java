package com.SystemHestia.repository;

import com.SystemHestia.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportJpaRepository extends JpaRepository<Report, Integer> {

//    List<Report> findByPatientId(Integer patientId);

    // Si activás la relación con Medicine en Report
//    List<Report> findByMedicineId(Integer medicineId);
}
