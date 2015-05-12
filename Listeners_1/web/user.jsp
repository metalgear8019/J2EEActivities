<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:42 PM
    Author     : mets
--%>

<%@page import="com.example.dao.UserDao"%>
<%@page import="com.example.model.UserBean"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);

    String btn = "";
    UserBean user = new UserBean();
    user.setUserid(0);
    user.setUsername("");
    user.setPassword("");
    
    if(request.getParameter("action").equals("add"))
        btn = "Add User";
    else
    {
        btn = "Update User";
        user = UserDao.getUserById(Integer.parseInt(request.getParameter("userid")));
    }
    
    if(session.getAttribute("username") != null)
    {
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <div>
            <a href="home.jsp">Home</a> |  <a href="profile.jsp">Profile</a> | <a href="LogoutServlet">Logout</a>
        </div>
        <h1>Hello <%= session.getAttribute("username") %>!</h1>
        Add a user below:<br>
        <form method="POST" action="UserController">
            <input type="hidden" name="userid" value="<%= user.getUserid() %>">
            Username: <input type="text" name="username" value="<%= user.getUsername() %>"><br>
            Password: <input type="password" name="password" value="<%= user.getPassword() %>"><br>
            <input type="submit" value="<%= btn %>">
        </form>
    </body>
</html>

<%
    }
    else
    {
        response.sendRedirect("");
    }
%>
