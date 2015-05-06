/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mets
 */
public class ProcessUserServlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String box = request.getParameter("box");
        String[] languages = request.getParameterValues("languages");
        PrintWriter out = response.getWriter();
        
        out.println("<h1>Hello <u>" + type + "</u> " + name + "!</h1>");
        out.println("<h2>Are you sure you deserve to be in " + course + "?</h2>");
        out.println("Train in these languages first: ");
        for(int i = 0; languages != null && i < languages.length; i++)
            out.println(languages[i] + ((i+1 < languages.length)?", ":""));
        out.println("<br>Oh, you chose " + box + "!");
        if(box.equals("Mayweather"))
            out.println("Here's a warm hug for you.");
        else
            out.println("He lost, move on.");
    }
        
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {        
        processRequest(request, response);
    }
}
