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
   Profile profile;

    public Person() {
    }

    public Person(Integer id, String username, Profile profile) {
        this.id = id;
        this.username = username;
        this.profile = profile;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", profile=" + profile +
                '}';
    }
}
