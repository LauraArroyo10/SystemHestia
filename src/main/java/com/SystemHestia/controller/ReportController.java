package com.SystemHestia.controller;

import com.SystemHestia.model.Report;
import com.SystemHestia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping
    public List<Report> getAll() {
        return reportService.getAll();
    }
// lo que esta en service se debe de hacer AQUIIIIIIIIII CON LA LO DE PUT GET PATCH DELETE

}