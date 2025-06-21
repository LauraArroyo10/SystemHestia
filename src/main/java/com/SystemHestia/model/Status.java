package com.SystemHestia.model;

public enum Status {
    ACTIVE("Activo"),
    COMPLETED("Completado"),
    SUSPENDED("Suspendido");
    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }
}
