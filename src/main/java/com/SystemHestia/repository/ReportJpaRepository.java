package com.SystemHestia.repository;

import com.SystemHestia.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

// cuando aparece Id ES Integer

public interface ReportJpaRepository extends JpaRepository <Report, Integer> {

//List<Report> findByCreatedDate(LocalDate date);


    }

