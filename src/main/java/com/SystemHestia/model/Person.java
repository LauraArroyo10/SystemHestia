package com.SystemHestia.model;

public class Person {

   String id;
   String username;
   Profile profile;

    public Person() {
    }

    public Person(String id, String username, Profile profile) {
        this.id = id;
        this.username = username;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
