package com.cereb.restapi.cerebai_interview;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {

    private @Id @GeneratedValue UUID id;
    private String email;
    private String password;

    User() {
    }

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public UUID getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }


    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", email='" + this.email + '\'' + ", password='" + this.password + '\'' + '}';
    }

}
