package com.example.demo.Model;

public class T_User {
    
    private Integer id;
    private String username;
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "{id=" + this.id + ", username=" + this.username + ", password=" + this.password + "}";
    }
}
