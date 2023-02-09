package com.example.cart.entity;


import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "user_table")
public class User {


    @jakarta.persistence.GeneratedValue

    @jakarta.persistence.Id
    private Integer userId;

    private String userName;
    private String password;

    private String role;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
