package com.SystemHestia.repository;

import com.SystemHestia.model.Medication;
import com.SystemHestia.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MedicationRepository extends CRUDMemory<Medication>{



    private ArrayList<Medication> data= new ArrayList<>();


    public MedicationRepository() {
    }

    //GET ALL
    public ArrayList<Medication>getAll(){
        return data;
    }





//GET BY ID
public Medication findById(Integer id){
    for(Medication element: data){
        if(element.getId().equals(id)){
            return element;
        }
    }
    return null;
}


//POST
public Medication add(Medication medication){
    data.add(medication);
    return medication;
}

//DELETE
public Medication delete(Integer id){
    for(int element=0;element<data.size();element++){
        if(data.get(element).getId()==id){
            return data.remove(element);
        }
    }
    return null;
}


//PUT
public Medication update(Medication element) {
    for(int index=0; index < data.size(); index++){
        if(data.get(index).getId().intValue()==element.getId().intValue()){
            return data.set(index, element);
        }
    }
    return null;
}

    @Override
    public Medication edit(Medication medication) {
            for (Medication element : data) {
                if (element.getId().intValue() == medication.getId().intValue()) {
                    if (medication.getIdentification() != null) {
                        element.setIdentification(medication.getIdentification());
                    }
                    if (medication.getName() != null) {
                        element.setName(medication.getName());
                    }
                    if (medication.getExpirationDate() != null) {
                        element.setExpirationDate(medication.getExpirationDate());
                    }
                    if (medication.getQuantity() != null) {
                        element.setQuantity(medication.getQuantity());
                    }
                    if (medication.getSideEffects() != null) {
                        element.setSideEffects(medication.getSideEffects());
                    }
                    if (medication.getInstructions() != null) {
                        element.setInstructions(medication.getInstructions());
                    }
                    if (medication.getType() != null) {
                        element.setType(medication.getType());
                    }

                    return element;
                }
            }
            return null;
        }


}//fin
