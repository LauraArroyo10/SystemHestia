package com.SystemHestia.model;

public enum MedicineType {

    TOPICALS ("Tópico"),
    LIQUIDS ("Líquido"),
    SOLIDS ("Sólido"),
    SEMISOLIDS ("Semi sólido");

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
