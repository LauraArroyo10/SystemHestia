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
    @GetMapping

    //GET All
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAll();
        if (reports.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(reports);
        }
    }
    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Report> report = reportService.getById(id);
        if (report.isPresent()) {
            return ResponseEntity.ok(report.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT
    @PutMapping
    public ResponseEntity<?> editReport(@RequestBody Report report) {
        Optional<Report> updated = reportService.edit(report);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PATCH
    @PatchMapping
    public ResponseEntity<?> patchReport(@RequestBody Report report) {
        Optional<Report> updated = reportService.edit(report);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // POST

    @PostMapping
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        Report savedReport = reportService.add(report);
        if (savedReport != null && savedReport.getId() != null) {
            return ResponseEntity.ok(savedReport);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Integer id) {
        Optional<Report> deleted = reportService.delete(id);
        if (deleted.isPresent()) {
            return ResponseEntity.ok(deleted.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
