package com.SystemHestia.controller;

import com.SystemHestia.model.Report;
import com.SystemHestia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// clases obejto id y generate value

@RestController
@RequestMapping ("/report")

public class ReportController {
  @Autowired
    ReportService reportService;
          private List <Report> reports;

          @GetMapping
    public List <Report> getAll () {

              return ReportService.getAll();
          }

}
