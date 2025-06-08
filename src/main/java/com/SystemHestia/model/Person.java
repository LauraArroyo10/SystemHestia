package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    @JsonProperty("id")
   Integer id;
    @JsonProperty("username")
   String username;
    @JsonProperty("profile")
    Role role;

    public Person() {
    }

    public Person(Integer id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getProfile() {
        return role;
    }

    public void setProfile(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", profile=" + role +
                '}';
    }
}
