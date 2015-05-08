/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author mets
 */
public class UserBean {
    private String username;
    private String password;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString()
    {
        return "Username: " + username + " | Password: " + password;
    }
        
    public boolean isUserValid(String usernmae, String password)
    {
        boolean valid = false;
        if(username.equals(this.username) && password.equals(this.password))
            valid = true;
        return valid;
    }
}
