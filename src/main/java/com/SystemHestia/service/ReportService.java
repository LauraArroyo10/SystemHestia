package com.SystemHestia.service;

import com.SystemHestia.dto.ReportDTO;
import com.SystemHestia.model.Report;
import com.SystemHestia.model.Treatment;
import com.SystemHestia.repository.ReportJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReportService {

    @Autowired
    ReportJpaRepository reportRepository;

    // OBTENER TODOS LOS REPORTES
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

//    // OBTENER REPORTES DE PACIENTE
//    public List<Report> getReportsByPatientId(Integer patientId) {
//        return reportRepository.findByPatientId(patientId);
//    }

    // OBTENER REPORTES DE MEDICAMENTOS (si activás la relación)
//    public List<Report> getReportsByMedicineId(Integer medicineId) {
//        return reportRepository.findByMedicineId(medicineId);
//    }

    // AÑADIR NUEVO REPORTE
    public Report add(Report report) {
        return reportRepository.save(report);
    }

    // OBTENER REPORTE POR ID
    public Optional<Report> getById(Integer id) {
        return reportRepository.findById(id);
    }

    // ELIMINAR REPORTE SIN LAMBDA
    public Optional<Report> delete(Integer id) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isPresent()) {
            reportRepository.deleteById(id);
        }
        return report;
    }

    // EDITAR
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
            if (report.getDescription() != null) {
                reportBd.setDescription(report.getDescription());
            }

            Report saved = reportRepository.save(reportBd);
            return Optional.of(saved);
        } else {
            return Optional.empty();
        }
    }

        public Report add(ReportDTO reportDTO) {
//            Patient patient = patientService.getPatient(reportDTO.getPatientId());
//            Medicine medicine = medicineService.getMedicine(reportDTO.getMedicineId());
//            Treatment treatment = treatmentService.getTreatment(reportDTO.getTreatmentId());

            Report report = new Report();
            report.setTitle(reportDTO.getTitle());
            report.setDate(reportDTO.getDate());
            report.setCategory(reportDTO.getCategory());
            report.setDescription(reportDTO.getDescription());
//            report.setPatient(patient);
//            report.setMedicine(medicine);
//            report.setTreatment(treatment);

            return reportRepository.save(report);
        }
}
