package com.SystemHestia.model;

public enum Role {
    //profile constants
    ADMIN("Administrador"),
    GUEST("Invitado"),
    KID("Menor de edad");

    private String role;


   Role(String role) {
       this.role = role;
    }

    public String getRole() {

       return role;
    }


    @Override
    public String toString() {
        return "Profile{" +
                ", role='" + role + '\'' +
                '}';
    }
}

