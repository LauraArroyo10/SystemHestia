package com.SystemHestia.controller;

import com.SystemHestia.model.Disease;
import com.SystemHestia.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diseases")
public class DiseaseController {
    @Autowired
    private DiseaseService service;


    //GET ALL
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<?> disease = service.getAll();
        if(disease ==null || disease.isEmpty()){
            return ResponseEntity.ok("No existe registro de enfermedad");
        }
        return ResponseEntity.ok(service.getAll());
    }


    //GET ALL BY ID
    @GetMapping ("{id}")
    public ResponseEntity<Disease> getId(@PathVariable int id){

        return ResponseEntity.ok(service.findById(id)) ;
    }


    //POST
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Disease disease){
        return ResponseEntity.ok(service.add(disease));
    }



    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    //
}
