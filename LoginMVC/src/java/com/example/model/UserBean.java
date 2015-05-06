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
    private String username = "kim";
    private String password = "agustin";
    
    public boolean isUserValid(String usernmae, String password)
    {
        boolean valid = false;
        if(username.equals(this.username) && password.equals(this.password))
            valid = true;
        return valid;
    }
}
