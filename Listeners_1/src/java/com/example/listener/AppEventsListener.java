/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author mets
 */
public class AppEventsListener implements ServletContextListener, HttpSessionListener {
    ServletContext context;
    public static int activeUsers = 0;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        String val = (String) session.getAttribute("counter");
        int counter = 1;
        if(val != null) {
            counter = Integer.parseInt(val);
            counter++;
        }
        session.setAttribute("counter", String.valueOf(counter));
        log("CREATE, Active Users: " + (++activeUsers), hse);
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        long start = session.getCreationTime();
        long end = session.getLastAccessedTime();
        String counter = (String) session.getAttribute("counter");
        --activeUsers;
        log("DESTRY, Session Duration:" + (end-start) + " ms Counter:" + counter, hse);
    }

    protected void log(String msg, HttpSessionEvent hse) {
        String id = hse.getSession().getId();
        log("SessionID:" + id + " " + msg);
    }

    protected void log(String msg) {
        System.out.println("{" + getClass().getName() + "} " + msg);
    }
}
