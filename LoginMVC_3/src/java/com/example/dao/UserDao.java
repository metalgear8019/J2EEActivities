/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.util.DbUtil;
import com.example.model.UserBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author mets
 */
public class UserDao extends HttpServlet {
    
    public static boolean isValid(UserBean user) throws IOException
    {
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement("" + "select * from users where username=? and password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                result = true;
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e)
        {
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String args[]) throws IOException
    {
        UserBean user = new UserBean();
        user.setUsername("kim");
        user.setPassword("agustin");
        
        System.out.println(UserDao.isValid(user));
    }

}
