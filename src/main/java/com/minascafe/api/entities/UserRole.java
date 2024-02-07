package com.minascafe.api.entities;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role; // atributo

    UserRole(String role) { // não precisa de atributo de acesso (public por exemplo)
        this.role = role;
    }

    public String getRole() { // adquire a role que esse método representa
        return role;
    }
}
