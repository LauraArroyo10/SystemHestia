//package com.SystemHestia.controller;
//import com.SystemHestia.model.Medication;
//import com.SystemHestia.service.MedicationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RequestMapping ("/medications")
//@RestController
//
//public class MedicationController {
//    @Autowired
//    MedicationService service;
//
//    //GET ALL
//    @GetMapping
//    public ArrayList<Medication> getAll(){
//        return service.getAll();
//    }
//    //GET ALL BY ID
//    @GetMapping ("{id}")
//    public Medication get(@PathVariable int id){
//        return service.findById(id);
//    }
//
//
//    //POST
//    @PostMapping
//    public Medication post(@RequestBody Medication medication){
//        return service.add(medication);}
//
//    //PUT
//    @PutMapping
//    public Medication put(@RequestBody Medication medication ){
//        return service.update(medication);
//    }
//
//    //DELETE       COMENTARIO
//    @DeleteMapping("{id}")
//    public Medication delete(@PathVariable int id){
//        return service.delete(id);
//    }
//
//    //PATCH
//    @PatchMapping
//    public Medication patchSpace (@RequestBody Medication medication) {
//
//        return service.edit(medication);
//    }
//
//}
