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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement stmt = connection.prepareStatement("select * from users where username=? and password=?");
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
    
    public static boolean addUser(UserBean user) throws IOException
    {
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement("insert into users(username, password) values(?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.execute();
            
            stmt.close();
            db.disconnect();
            result = true;
        }
        catch(SQLException e)
        {
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static boolean deleteUser(int userid) throws IOException
    {
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement("delete from users where userid=?");
            stmt.setInt(1, userid);
            stmt.execute();
            
            stmt.close();
            db.disconnect();
            result = true;
        }
        catch(SQLException e)
        {
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static boolean updateUser(UserBean user) throws IOException
    {
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement("update users set username=?, password=? where userid=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUserid());
            stmt.execute();
            
            stmt.close();
            db.disconnect();
            result = true;
        }
        catch(SQLException e)
        {
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
    }
    
    public static List<UserBean> getAllUsers() throws IOException
    {
        List<UserBean> users = new ArrayList();
        DbUtil db = new DbUtil();
        
        try
        {
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            
            while(rs.next())
            {
                UserBean user = new UserBean();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
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
        return users;
    }
        
    public static UserBean getUserById(int userId) throws IOException
    {
        UserBean user = new UserBean();
        DbUtil db = new DbUtil();
        
        try
        {
            PreparedStatement stmt = db.getConnection().prepareStatement("select * from users where userid=?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            user.setUserid(userId);
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e)
        {
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return user;
    }
    
    public static void main(String args[]) throws IOException
    {
        UserBean user = new UserBean();
        user.setUsername("kim");
        user.setPassword("agustin");
        
        System.out.println(UserDao.isValid(user));
    }

}
