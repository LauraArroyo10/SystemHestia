package com.SystemHestia.repository;

import com.SystemHestia.model.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
@Repository
public class PatientRepository  extends CRUDMemory<Patient>{

    private ArrayList<Patient> data= new ArrayList<>();


    public PatientRepository() {
    }

    //GET ALL
    public ArrayList<Patient>getAll(){
        return data;
    }


    //GET BY ID
    public Patient findById(Integer id){
        for(Patient element: data){
            if(element.getId().equals(id)){
                return element;
            }
        }
        return null;
    }


    //POST
    public Patient add(Patient patient){
        data.add(patient);
        return patient;
    }

    //PUT
    @Override
    public Patient edit(Patient patient) {
        for (Patient element : data) {
            if (element.getId().intValue() == patient.getId().intValue()) {
                if (patient.getUsername()!=null) {
                    element.setUsername(patient.getUsername());
                }
                if (patient.getAge()!=null) {
                    element.setAge(patient.getAge());
                }
                if (patient.getAllergies()!=null) {
                    element.setAllergies(patient.getAllergies());
                }
                if (patient.getConditions()!=null) {
                    element.setConditions(patient.getConditions());
                }
                if (patient.getDiseases()!=null) {
                    element.setDiseases(patient.getDiseases());
                }
                if (patient.getIdentification()!=null) {
                    element.setIdentification(patient.getIdentification());
                }
                if (patient.getProfile()!=null) {
                    element.setProfile(patient.getProfile());
                }

                return element;
            }
        }
        return null;
    }

    //DELETE
    public Patient delete(Integer id){
        for(int element=0;element<data.size();element++){
            if(data.get(element).getId()==id){
                return data.remove(element);
            }
        }
        return null;
    }


    public Patient update(Patient element) {
        for(int index=0; index < data.size(); index++){
            if(data.get(index).getId().intValue()==element.getId().intValue()){
                return data.set(index, element);
            }
        }
        return null;
    }
    //PATCH



}
