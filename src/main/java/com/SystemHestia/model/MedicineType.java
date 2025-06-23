package com.SystemHestia.model;

public enum MedicineType {

    TOPICALS ("Topico"),
    LIQUIDS ("Liquido"),
    SOLIDS ("Solido"),
    SEMISOLIDS ("Semi solido");

    private String type;

    MedicineType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MedicineType{" +
                "type='" + type + '\'' +
                '}';
    }

}
