package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Disease {

    private String name;
    private String description;
    private String recommendedMedicine1;
    private String recommendedMedicine2;

    public Disease() {
    }

    public Disease(String name, String description, String recommendedMedicine1, String recommendedMedicine2) {
        this.name = name;
        this.description = description;
        this.recommendedMedicine1 = recommendedMedicine1;
        this.recommendedMedicine2 = recommendedMedicine2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendedMedicine1() {
        return recommendedMedicine1;
    }

    public void setRecommendedMedicine1(String recommendedMedicine1) {
        this.recommendedMedicine1 = recommendedMedicine1;
    }

    public String getRecommendedMedicine2() {
        return recommendedMedicine2;
    }

    public void setRecommendedMedicine2(String recommendedMedicine2) {
        this.recommendedMedicine2 = recommendedMedicine2;
    }

    @Override
    public String toString() {
        return name;
    }
}
