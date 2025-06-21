package com.SystemHestia.service;

import com.SystemHestia.model.Report;
import com.SystemHestia.repository.ReportJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReportService {
    @Autowired
    ReportJpaRepository reportRepository;
// OBTNER TODOS LOS REPORTES
    public List<Report> getAll(){return reportRepository.findAll();}
// consultar cantidad de medicamentos disponibles

// mio


    // Obtener reporte por ID
    public Optional<Report> getById(Integer id) {
        return reportRepository.findById(id);
    }

    // Obteber reportes de paciente


    //obtener reportes de medicamentos

    // Eliminar reporte
    public Optional<Report> delete(Integer id) {
        Optional<Report> report = reportRepository.findById(id);
        report.ifPresent(r -> reportRepository.deleteById(id));
        return report;
    }
    //ediatar reportes

        // Editar reporte (actualizarlo)
        public Optional<Report> edit(Report report) {
            Optional<Report> existingReport = reportRepository.findById(report.getId());
            if (existingReport.isPresent()) {
                Report reportBd = existingReport.get();

                if (report.getTitle() != null) {
                    reportBd.setTitle(report.getTitle());
                }
                if (report.getDate() != null) {
                    reportBd.setDate(report.getDate());
                }
                if (report.getCategory() != null) {
                    reportBd.setCategory(report.getCategory());
                }

                reportRepository.save(reportBd);
                return Optional.of(reportBd);
            }
            return Optional.empty();
        }
    }