/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mets
 */
public class UserController extends HttpServlet {
    
    private static final String addOrEdit = "user.jsp";
    private static final String home = "home.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        
        String action = request.getParameter("action");
        if(action.equals("edit"))
        {
            int userid = Integer.parseInt(request.getParameter("userid"));
            UserBean user = UserDao.getUserById(userid);
            request.setAttribute("user", user);
            forward = addOrEdit;
        }
        else if(action.equals("add"))
        {
            forward = addOrEdit;
        }
        else if(action.equals("delete"))
        {
            int userid = Integer.parseInt(request.getParameter("userid"));
            UserDao.deleteUser(userid);
            forward = home;
            HttpSession session = request.getSession(false);
            session.setAttribute("users", UserDao.getAllUsers());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean user = new UserBean();
        user.setPassword(password);
        user.setUsername(username);
        user.setUserid(id);
        
        if(id != 0)
            UserDao.updateUser(user);
        else
            UserDao.addUser(user);
        
        HttpSession session = request.getSession(false);
        session.setAttribute("users", UserDao.getAllUsers());
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
