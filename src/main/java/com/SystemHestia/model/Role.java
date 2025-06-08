package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Role {
    //profile constants
    public static final String ADMIN = "Administrador";
    public static final String VIEWER = "Espectador";
    public static final String KID =  "Menor de edad";
    private String id;
    private String role;


    public Role() {
    }

    public Role(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

