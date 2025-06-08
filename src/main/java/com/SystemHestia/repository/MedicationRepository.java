package com.SystemHestia.repository;

import com.SystemHestia.model.Medication;

import java.util.ArrayList;

public class MedicationRepository extends CRUDMemory<Medication>{

    @Override
    public Medication edit(Medication element) {
        return null;
    }

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
//    public Medication delete(Integer id){
//        for(int element=0;element<data.size();element++){
//            if(data.get(element).getId()==id){//data.get(element).getId()==id){
//                return data.remove(element);
//            }
//        }
//        return null;
//    }
//
//
//    //PUT
//    public Medication update(Medication element) {
//        for(int index=0; index < data.size(); index++){
//            if(data.get(index).getId().intValue()==element.getId().intValue()){
//                return data.set(index, element);
//            }
//        }
//        return null;
//    }

    }//fin
