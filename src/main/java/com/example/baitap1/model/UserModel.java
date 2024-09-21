package com.example.baitap1.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
    private int id;
    protected String username;
    protected String password;
    protected String email;
    protected int role;
    protected String phone;
    protected Date createdDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
