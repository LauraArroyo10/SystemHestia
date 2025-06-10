package com.SystemHestia.service;

import com.SystemHestia.model.Report;
import com.SystemHestia.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReportService {
@Autowired
    ReportRepository reportRepository;

    public List<Report> getAll(){return repository.getAll();}


}
