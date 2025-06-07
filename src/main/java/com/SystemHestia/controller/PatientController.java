package com.SystemHestia.controller;

import com.SystemHestia.model.Patient;
import com.SystemHestia.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/patients")
public class PatientController {

@Autowired
    PatientService service;

//GET ALL
@GetMapping
public ArrayList<Patient>getAll(){
    return service.getAll();
}
//GET ALL BY ID
}
