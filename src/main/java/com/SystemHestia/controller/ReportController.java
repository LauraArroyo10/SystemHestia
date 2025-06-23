package com.SystemHestia.controller;

import com.SystemHestia.model.Report;
import com.SystemHestia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    // GET ALL
    @GetMapping
    public List<Report> getAll() {
        return reportService.getAll();
    }

    // GET Reports by Patient ID
    @GetMapping("/patient/{patientId}")
    public List<Report> getReportsByPatient(@PathVariable Integer patientId) {
        return reportService.getReportsByPatientId(patientId);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Report> report = reportService.getById(id);
        return report.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        Report saved = reportService.add(report);
        return ResponseEntity.ok(saved);
    }

    // PUT
    @PutMapping
    public ResponseEntity<?> editReport(@RequestBody Report report) {
        Optional<Report> updated = reportService.edit(report);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PATCH
    @PatchMapping
    public ResponseEntity<?> patchReport(@RequestBody Report report) {
        Optional<Report> updated = reportService.edit(report);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Integer id) {
        Optional<Report> deleted = reportService.delete(id);
        return deleted.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
