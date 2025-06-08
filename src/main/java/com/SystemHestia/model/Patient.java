package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient extends Person implements Identifiable{
    private String identification;
    private String age;
    private String conditions;
    private Disease diseases;
    private String allergies;

    public Patient() {
    }

    public Patient(String identification, String age, String conditions, Disease diseases, String allergies) {
        this.identification = identification;
        this.age = age;
        this.conditions = conditions;
        this.diseases = diseases;
        this.allergies = allergies;
    }

    public Patient(Integer id, String username, Profile profile, String identification, String age, String conditions, Disease diseases, String allergies) {
        super(id, username, profile);
        this.identification = identification;
        this.age = age;
        this.conditions = conditions;
        this.diseases = diseases;
        this.allergies = allergies;
    }


    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Disease getDiseases() {
        return diseases;
    }

    public void setDiseases(Disease diseases) {
        this.diseases = diseases;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }


//    public String getProperty(int index) {
//        switch (index) {
//            case 0:
//                return id;
//            case 1:
//                return username;
//            case 2:
//                return identification;
//            case 3:
//                return age;
//            case 4:
//                if (diseases != null) {
//                    return diseases.getName();
//                } else {
//                    return "No existe una enfermedad asignada.";
//                }
//            default:
//                throw new AssertionError("Índice fuera de rango: " + index);
//        }
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        Patient other = (Patient) obj;
//        return this.getId() != null && this.getId().equalsIgnoreCase(other.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        if (this.getId() != null) {
//            return this.getId().toLowerCase().hashCode();
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Patient{" + "identification=" + identification + ", age=" + age + ", conditions=" + conditions + ", diseases=" + diseases + ", allergies=" + allergies + '}';
//    }


}
