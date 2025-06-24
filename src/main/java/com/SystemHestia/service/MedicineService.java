package com.SystemHestia.service;
import com.SystemHestia.model.Medicine;
import com.SystemHestia.repository.MedicineRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepositoryJPA repository;

    //GET ALL
    public List<Medicine> getAll() {
        return repository.findAll();
    }


    //GET BY ID
    public Medicine findById(Integer id) {
        Optional<Medicine> medicine = repository.findById(id);
        if (medicine.isPresent()) {
            return medicine.get();
        }
        return null;
    }


    //POST
    public Medicine add(Medicine medicine) {

        return repository.save(medicine);
    }

    //Patch
    public Medicine update (Medicine medicine){
        Optional<Medicine> medicineExist = repository.findById(medicine.getId());
        if (medicineExist.isPresent()){
            return repository.save(medicine);
        }
        return medicine;

    }

    public Medicine edit(Medicine medicine) {
        Medicine element = getMedicine(medicine.getId());

        if (element != null && element.getId().equals(medicine.getId())) {
            if (medicine.getName() != null) {
                element.setName(medicine.getName());
            }
            if (medicine.getMedicineType() != null) {
                element.setMedicineType(medicine.getMedicineType());
            }
            if (medicine.getExpirationDate() != null) {
                element.setExpirationDate(medicine.getExpirationDate());
            }
            if (medicine.getInstructions()!=null){
                element.setInstructions(medicine.getInstructions());
            }
            if (medicine.getIdentification()!=null){
                element.setIdentification(medicine.getIdentification());
            }
            if (medicine.getQuantity()!=null){
                element.setQuantity(medicine.getQuantity());
            }
            if (medicine.getSideEffects()!=null){
                element.setSideEffects(medicine.getSideEffects());
            }

            return repository.save(element);
        }
        return null;
    }

    //DELETE
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public Medicine dUpdate(Medicine medicine) {
        return repository.save(medicine);
    }


    // VALIDACIONES
    public boolean existByName(String name) {
        return repository.existsByName(name);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    // BÚSQUEDAS ADICIONALES
    public Medicine getByName(String name) {
        return repository.findByName(name);
    }



    public Medicine getMedicine(Integer id) {
        Optional<Medicine> medicine = repository.findById(id);
        if (medicine.isPresent()) {
            return medicine.get();
        }
        return null;
    }


}
