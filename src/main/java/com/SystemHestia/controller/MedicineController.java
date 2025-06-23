package com.SystemHestia.controller;

import com.SystemHestia.model.Disease;
import com.SystemHestia.model.Medicine;
import com.SystemHestia.service.DiseaseService;
import com.SystemHestia.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService service;


    //GET ALL
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<?> medicines = service.getAll();
        if(medicines ==null || medicines.isEmpty()){
            return ResponseEntity.ok("No existen medicamentos");
        }
        return ResponseEntity.ok(service.getAll());
    }


    //GET ALL BY ID
    @GetMapping ("{id}")
    public Medicine get(@PathVariable int id){
        return service.findById(id);
    }


    //POST
    @PostMapping
    public Medicine post(@RequestBody Medicine medicine){
        return service.add(medicine);}


    //PUT
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Medicine medicine){
        if (service.existsById(medicine.getId())){

            return ResponseEntity.ok(service.update(medicine));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ese id no se encuentra registrado");
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


    //PATCH
    @PatchMapping
    public ResponseEntity<?> patch (@RequestBody Medicine medicine) {

        if (service.existsById(medicine.getId())){
            return ResponseEntity.ok(service.edit(medicine));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id "+medicine.getId()+" no está registrado");
    }

    @GetMapping("/count")
    public long countAvailableMedicines() {
        return service.countAvailableMedicines();

    }



}
